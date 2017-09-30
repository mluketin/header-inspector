package hr.element.headerinspector.impl;

public enum Inspectors {
    JPEG(JpegInspector.INSTANCE),
    GIF(GifInspector.INSTANCE),
    BMP(BmpInspector.INSTANCE),
    PNG(PngInspector.INSTANCE),
    TIF(TifInspector.INSTANCE),
    PPM(PpmInspector.INSTANCE),
    PGM(PgmInspector.INSTANCE),
    PBM(PbmInspector.INSTANCE),
    PAM(PamInspector.INSTANCE),
    WEBP(WebpInspector.INSTANCE);

    public final ImageInspectorCore imageInspectorCore;

    private Inspectors(final ImageInspectorCore imageInspectorCore) {
        this.imageInspectorCore = imageInspectorCore;
    }


}
