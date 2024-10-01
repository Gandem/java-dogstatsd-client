package com.timgroup.statsd;

public enum ChannelTransportType {
    UDP("udp"),
    NAMEDPIPE("namedpipe"),
    UDS("uds"),
    UDSSTREAM("uds-stream");

    private final String text;

    ChannelTransportType(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
