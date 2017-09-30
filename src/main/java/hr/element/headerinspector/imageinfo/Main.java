package hr.element.headerinspector.imageinfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public final class Main {

    public static void main(String... aArgs) throws IOException {
//        final String path = "C:\\PictureSamples\\ESO.jpg";
//        final byte[] buffer = readFile(path);

//        //write image in hex
//        for (int i = 0; i < buffer.length / 2; i++) {
//            System.out.print(String.format("%02X ", buffer[i]));
//            if ((i + 1) % 4 == 0)
//                System.out.println();
//        }
//        System.out.println();

        Path fileDir = Paths.get("D:/images");
        ImageVisitor visitor = new ImageVisitor();
        Files.walkFileTree(fileDir, visitor);

//        ImageInspectorProxy imageInspectorProxy = new ImageInspectorProxy(buffer, ImageInfoImpl.getInspector(buffer));
//        System.out.println(imageInspectorProxy.getName());
//        System.out.println(imageInspectorProxy.getWidth());
//        System.out.println(imageInspectorProxy.getHeight());
    }


    public static byte[] readFile(final String path) throws IOException {
        final File file = new File(path);
        final int length = (int) file.length();

        final FileInputStream fis = new FileInputStream(file);
        final byte[] body = new byte[length];
        fis.read(body);
        fis.close();

        return body;
    }


    public static int getInt(final byte[] buffer, final int pos) {
        return (buffer[pos] & 0xff << 24) | (buffer[pos + 1] & 0xff << 16)
                | (buffer[pos + 2] & 0xff << 8) | (buffer[pos + 3] & 0xff);
    }

    public static int getLEInt(final byte[] buffer, final int pos) //little endian getInt verzija
    {
        return (buffer[pos + 3] & 0xff << 24) | (buffer[pos + 2] & 0xff << 16)
                | (buffer[pos + 1] & 0xff << 8) | (buffer[pos] & 0xff);
    }


}
