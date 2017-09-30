package hr.element.headerinspector.imageinfo;


import hr.element.headerinspector.impl.ImageInspectorCore;

public class ImageInspectorProxy implements ImageInspector {

    private byte[] content;
    private ImageInspectorCore imageInspectorCore;

    public ImageInspectorProxy(byte[] content, ImageInspectorCore imageInspectorCore) {
        this.content = content;
        this.imageInspectorCore = imageInspectorCore;
    }

    @Override
    public String getName() {
        return imageInspectorCore.getName();
    }

    @Override
    public int getWidth() {
        return imageInspectorCore.getWidth(content);
    }

    @Override
    public int getHeight() {
        return imageInspectorCore.getHeight(content);
    }

}
