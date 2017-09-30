package hr.element.headerinspector.impl;


public enum PngInspector implements ImageInspectorCore {
    INSTANCE;

    @Override
    public String getName() {
        return "PNG";
    }

    @Override
    public int getWidth(final byte[] buffer) {
        return ((buffer[16] & 0xff) << 24) | ((buffer[17] & 0xff) << 16) | ((buffer[18] & 0xff) << 8) | ((buffer[19] & 0xff));
    }

    @Override
    public int getHeight(final byte[] buffer) {
        return ((buffer[20] & 0xff) << 24) | ((buffer[21] & 0xff) << 16) | ((buffer[22] & 0xff) << 8) | ((buffer[23] & 0xff));
    }

    @Override
    public boolean isFormat(final byte[] buffer) {
        return ((buffer[0] & 0xff) == 0x89) && ((buffer[1] & 0xff) == 0x50)
                && ((buffer[2] & 0xff) == 0x4E) && ((buffer[3] & 0xff) == 0x47)
                && ((buffer[4] & 0xff) == 0x0D) && ((buffer[5] & 0xff) == 0x0A)
                && ((buffer[6] & 0xff) == 0x1A) && ((buffer[7] & 0xff) == 0x0A);
    }

}
