package hr.element.headerinspector.impl;


public enum TifInspector implements ImageInspectorCore {
    INSTANCE;

    @Override
    public String getName() {
        return "TIF";
    }

    @Override
    public int getWidth(final byte[] buffer) {
        int Width = 0;
        final int OFFSET_NA_VALUE = 8;

        for (int i = 0; i < buffer.length - 12; i++) {
            if (buffer[0] == 0x49 && buffer[1] == 0x49) {
                if ((buffer[i] == 0x00) && (buffer[i + 1] == 0x01))    //tag je width, ovo vridi samo za little endian  kad su prva dva bajta filea 0x49
                {
                    if ((buffer[i + 2] == 0x03) && (buffer[i + 3] == 0x00)) {
                        if (buffer[i + 4] == 0x01 && buffer[i + 5] == 0x00 && buffer[i + 6] == 0x00 && buffer[i + 7] == 0x00)    //ako je istinito onda je vrijednost short
                        {
                            Width = (buffer[i + OFFSET_NA_VALUE] & 0xff) | (buffer[i + OFFSET_NA_VALUE + 1] & 0xff) << 8;
                            return Width;
                        }
                    } else if ((buffer[i + 2] == 0x04) && (buffer[i + 3] == 0x00))//long
                    {
                        if (buffer[i + 4] == 0x01 && buffer[i + 5] == 0x00 && buffer[i + 6] == 0x00 && buffer[i + 7] == 0x00) {
                            Width = (buffer[i + OFFSET_NA_VALUE] & 0xff) | (buffer[i + OFFSET_NA_VALUE + 1] & 0xff) << 8 | (buffer[i + OFFSET_NA_VALUE + 2] & 0xff) << 16 | (buffer[i + OFFSET_NA_VALUE + 3] & 0xff) << 24;
                        }
                    }
                }
            } else if (buffer[0] == 0x4D && buffer[1] == 0x4D) {
                if ((buffer[i] == 0x01) && (buffer[i + 1] == 0x00)) {
                    if ((buffer[i + 2] == 0x00) && (buffer[i + 3] == 0x03)) {
                        if (buffer[i + 4] == 0x00 && buffer[i + 5] == 0x00 && buffer[i + 6] == 0x00 && buffer[i + 7] == 0x01)    //ako je istinito onda je vrijednost short
                        {
                            Width = ((buffer[i + OFFSET_NA_VALUE] & 0xff) << 8) | (buffer[i + OFFSET_NA_VALUE + 1] & 0xff);
                            return Width;
                        }
                    } else if ((buffer[i + 2] == 0x00) && (buffer[i + 3] == 0x04))//long
                    {
                        if (buffer[i + 4] == 0x00 && buffer[i + 5] == 0x00 && buffer[i + 6] == 0x00 && buffer[i + 7] == 0x01) {
                            Width = (buffer[i + OFFSET_NA_VALUE + 4] & 0xff) | (buffer[i + OFFSET_NA_VALUE + 3] & 0xff) << 8 | (buffer[i + OFFSET_NA_VALUE + 2] & 0xff) << 16 | (buffer[i + OFFSET_NA_VALUE + 1] & 0xff) << 24;
                        }
                    }
                }
            }

        }
        return Width;
    }

    @Override
    public int getHeight(final byte[] buffer) {
        int Height = 0;
        final int OFFSET_NA_VALUE = 8;

        for (int i = 0; i < buffer.length - 12; i++) {
            if (buffer[0] == 0x49 && buffer[1] == 0x49) {
                if ((buffer[i] == 0x01) && (buffer[i + 1] == 0x01))        //tag je Height, ovo vridi samo za little endian  kad su prva dva bajta filea 0x49
                {
                    if ((buffer[i + 2] == 0x03) && (buffer[i + 3] == 0x00)) {
                        if (buffer[i + 4] == 0x01 && buffer[i + 5] == 0x00 && buffer[i + 6] == 0x00 && buffer[i + 7] == 0x00)    //ako je istinito onda je vrijednost short
                        {
                            Height = (buffer[i + OFFSET_NA_VALUE] & 0xff) | (buffer[i + OFFSET_NA_VALUE + 1] & 0xff) << 8;
                            return Height;
                        }
                    } else if ((buffer[i + 2] == 0x04) && (buffer[i + 3] == 0x00))  //long
                    {
                        if (buffer[i + 4] == 0x01 && buffer[i + 5] == 0x00 && buffer[i + 6] == 0x00 && buffer[i + 7] == 0x00) {
                            Height = (buffer[i + OFFSET_NA_VALUE + 4] & 0xff) | (buffer[i + OFFSET_NA_VALUE + 3] & 0xff) << 8 | (buffer[i + OFFSET_NA_VALUE + 2] & 0xff) << 16 | (buffer[i + OFFSET_NA_VALUE + 1] & 0xff) << 24;
                            return Height;
                        }
                    }
                }
            } else if (buffer[0] == 0x4D && buffer[1] == 0x4D) {
                if ((buffer[i] == 0x01) && (buffer[i + 1] == 0x01)) {

                    if ((buffer[i + 2] == 0x00) && (buffer[i + 3] == 0x03))                //ako je istinito onda je vrijednost short
                    {
                        if (buffer[i + 4] == 0x00 && buffer[i + 5] == 0x00 && buffer[i + 6] == 0x00 && buffer[i + 7] == 0x01) {
                            Height = ((buffer[i + OFFSET_NA_VALUE] & 0xff) << 8) | (buffer[i + OFFSET_NA_VALUE + 1] & 0xff);
                            return Height;
                        }
                    } else if ((buffer[i + 2] == 0x00) && (buffer[i + 3] == 0x04))  //long
                    {
                        if (buffer[i + 4] == 0x00 && buffer[i + 5] == 0x00 && buffer[i + 6] == 0x00 && buffer[i + 7] == 0x01) {
                            Height = (buffer[i + OFFSET_NA_VALUE + 3] & 0xff) | (buffer[i + OFFSET_NA_VALUE + 2] & 0xff) << 8 | (buffer[i + OFFSET_NA_VALUE + 1] & 0xff) << 16 | (buffer[i + OFFSET_NA_VALUE] & 0xff) << 24;
                            return Height;
                        }
                    }
                }
            }
        }

        return Height;
    }

    @Override
    public boolean isFormat(final byte[] buffer) {
        return ((buffer[0] == 0x49) && (buffer[1] == 0x49) && buffer[2] == 0x2A && (buffer[3] == 0x00)) || ((buffer[0] == 0x4D) && (buffer[1] == 0x4D) && buffer[2] == 0x00 && (buffer[3] == 0x2A));
    }

}
