package hr.element.headerinspector.impl;


public enum GifInspector implements ImageInspectorCore {
    INSTANCE;

    @Override
    public String getName() {
        return "GIF";
    }

    @Override
    public int getWidth(final byte[] buffer) {
        return ((buffer[7] & 0xff) << 8) | ((buffer[6] & 0xff));
    }

    @Override
    public int getHeight(final byte[] buffer) {
        return ((buffer[9] & 0xff) << 8) | ((buffer[8] & 0xff));
    }

    @Override
    public boolean isFormat(final byte[] buffer) {
        return (buffer[0] == 0x47) && (buffer[1] == 0x49) && (buffer[2] == 0x46);
    }


}
