package hr.element.headerinspector.imageinfo;


import hr.element.headerinspector.impl.ImageInspectorCore;
import hr.element.headerinspector.impl.Inspectors;

public class ImageInfoImpl {
    public static ImageInspectorCore getInspector(byte[] content) {
        for (final Inspectors iic : Inspectors.values()) {
            if (iic.imageInspectorCore.isFormat(content)) {
                return iic.imageInspectorCore;
            }
        }
        return null;
    }
}
