package hr.element.headerinspector.impl;


public enum BmpInspector implements ImageInspectorCore {
    INSTANCE;

    @Override
    public String getName() {
        return "BMP";
    }

    @Override
    public int getWidth(final byte[] buffer) {
        return ((buffer[21] & 0xff) << 24) | ((buffer[20] & 0xff) << 16)
                | ((buffer[19] & 0xff) << 8) | ((buffer[18] & 0xff));
    }

    @Override
    public int getHeight(final byte[] buffer) {
        return ((buffer[25] & 0xff) << 24) | ((buffer[24] & 0xff) << 16)
                | ((buffer[23] & 0xff) << 8) | ((buffer[22] & 0xff));
    }

    @Override
    public boolean isFormat(final byte[] buffer) {
        return buffer[0] == 0x42 && buffer[1] == 0x4d;
    }

}
