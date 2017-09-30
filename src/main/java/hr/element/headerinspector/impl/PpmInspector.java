package hr.element.headerinspector.impl;


public enum PpmInspector implements ImageInspectorCore {
    INSTANCE;

    @Override
    public String getName() {
        return "PPM";
    }

    @Override
    public int getWidth(final byte[] buffer) {
        final int nula = 48;
        int width = 0;

        int position;
        position = 3;
        while ((char) (buffer[position]) != ' ') {
            width *= 10;
            width += buffer[position] - nula;
            position++;

        }
        return width;
    }

    @Override
    public int getHeight(final byte[] buffer) {
        int razmak = 0;
        for (int i = 3; i < buffer.length; i++) {
            if ((buffer[i]) == 0x20) {
                razmak = i + 1;
                break;
            }

        }

        final int nula = 48;
        int height = 0;
        while ((char) (buffer[razmak]) != ' ' && (buffer[razmak] != 0xA)) {
            height *= 10;
            height += buffer[razmak] - nula;
            razmak++;

        }
        return height;
    }

    @Override
    public boolean isFormat(final byte[] buffer) {
        return (buffer[0] == 0x50) && ((buffer[1] == 0x36) || (buffer[1] == 0x33));
    }

}
