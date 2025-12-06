package com.midterm_2320481_8.weeding_event_management.samanta.client;

import java.io.Serializable;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AppendableObjectOutPutStream extends ObjectOutputStream {
    public AppendableObjectOutPutStream(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        //
    }
}
