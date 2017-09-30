package hr.element.headerinspector.impl;


public enum PamInspector implements ImageInspectorCore {
    INSTANCE;

    @Override
    public String getName() {
        return "PAM";
    }

    @Override
    public int getWidth(final byte[] buffer) {
        final int nula = 48;
        int width = 0;

        int position = 3 + 6; //na 0,1,2 se nalazi "P7" i \n onda ide "WIDTH" pa ' ' pa tek onda broj na buffer(9)

        while ((char) (buffer[position]) != '\n') {
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
            if ((buffer[i]) == 0x0A) {
                razmak = i + 1;
                break;
            }

        }

        final int nula = 48;
        int height = 0;
        razmak += 7; //"HEIGHT " pa je +7
        while ((char) (buffer[razmak]) != ' ' && (buffer[razmak] != 0xA)) {
            height *= 10;
            height += buffer[razmak] - nula;
            razmak++;

        }
        return height;
    }

    @Override
    public boolean isFormat(final byte[] buffer) {
        return (buffer[0] == 0x50) && ((buffer[1] == 0x37));
    }

}
