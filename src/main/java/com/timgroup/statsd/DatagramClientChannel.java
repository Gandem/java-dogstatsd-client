package com.timgroup.statsd;

import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

class DatagramClientChannel implements ClientChannel {
    protected final DatagramChannel delegate;
    private final SocketAddress address;

    /**
     * Creates a new DatagramClientChannel using the default DatagramChannel.
     * @param address Address to connect the channel to
     * @throws IOException if an I/O error occurs
     */
    DatagramClientChannel(SocketAddress address) throws IOException {
        this(DatagramChannel.open(), address);
    }

    /**
     * Creates a new DatagramClientChannel that wraps the delegate.
     * @param delegate Implementation this instance wraps
     * @param address Address to connect the channel to
     */
    DatagramClientChannel(DatagramChannel delegate, SocketAddress address) {
        this.delegate = delegate;
        this.address = address;
    }

    @Override
    public boolean isOpen() {
        return delegate.isOpen();
    }

    @Override
    public int write(ByteBuffer src) throws IOException {
        return delegate.send(src, address);
    }

    @Override
    public void close() throws IOException {
        delegate.close();
    }

    @Override
    public ChannelTransportType getTransportType() {
        return ChannelTransportType.UDP;
    }

    @Override
    public String toString() {
        return "[" + getTransportType() + "] " + address;
    }
}
