package hr.element.headerinspector.impl;


public enum WebpInspector implements ImageInspectorCore {
    INSTANCE;

    @Override
    public String getName() {
        return "WEBP";
    }

    @Override
    public int getWidth(final byte[] buffer) {
        return (((buffer[27] & 0xff) << 8) | (buffer[26] & 0xff));
    }

    @Override
    public int getHeight(final byte[] buffer) {
        return (((buffer[29] & 0xff) << 8) | (buffer[28] & 0xff));
    }

    @Override
    public boolean isFormat(final byte[] buffer) {
        return (buffer[0] == 0x52) && (buffer[1] == 0x49) && (buffer[2] == 0x46) && (buffer[3] == 0x46);
    }

}
