package hr.element.headerinspector.impl;

public interface ImageInspectorCore {
    String getName();

    boolean isFormat(final byte[] buffer);

    int getWidth(final byte[] buffer);

    int getHeight(final byte[] buffer);
}
