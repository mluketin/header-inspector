package hr.element.headerinspector.impl;


public enum JpegInspector implements ImageInspectorCore {
    INSTANCE;

    @Override
    public String getName() {
        return "JPEG";
    }

    @Override
    public int getWidth(final byte[] buffer) {
        int position;
        position = 0;

        for (int i = 0; i < buffer.length; i++) {
            if ((buffer[i] & 0xff) == 0xFF && (((buffer[i + 1] & 0xff) == 0xC0) || ((buffer[i + 1] & 0xff) == 0xC2)))
                position = i + 7; //jer je tako u SOF0 headeru postavljen value widtha
        }
        return ((buffer[position] & 0xff) << 8) | ((buffer[position + 1] & 0xff));
    }

    @Override
    public int getHeight(final byte[] buffer) {
        int position;
        position = 0;

        for (int i = 0; i < buffer.length; i++) {
            if ((buffer[i] & 0xff) == 0xFF && (((buffer[i + 1] & 0xff) == 0xC0) || ((buffer[i + 1] & 0xff) == 0xC2)))
                position = i + 5; //jer je tako u SOF0 headeru
        }
        return ((buffer[position] & 0xff) << 8) | ((buffer[position + 1] & 0xff));
    }

    @Override
    public boolean isFormat(final byte[] buffer) {
        return (buffer[0] & 0xff) == 0xff && (buffer[1] & 0xff) == 0xd8;
    }

}
