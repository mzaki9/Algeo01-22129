package matrix;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageUpscale {
    public static Matrix matrixpojok(int height, int width, BufferedImage image) {
        Matrix dasar = new Matrix(4, 4);
        if (width == 0 && height == 0) {
            for (int i = 1; i < 4; i++) {
                for (int j = 1; j < 4; j++) {
                    dasar.setElmt(i, j, image.getRGB(j, i));
                }
            }
            // dasar.setElmt(0, 0, dasar.getElmt(1, 1));
            // for (int i =1 ; i<4;i++){
            //     dasar.setElmt(0, i, dasar.getElmt(0, i));
            //     dasar.setElmt(i, 0, dasar.getElmt(0, i));
            // }
            
        } else if (width == image.getWidth() - 1 && height == 0) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    dasar.setElmt(i, j, image.getRGB(width - 3 + j, i));
                }
            }
        } else if (width == 0 && height == image.getHeight() - 1) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 0; j++) {
                    dasar.setElmt(i, j, image.getRGB(j, height - 3 + i));
                }
            }
        } else if (width == image.getWidth() - 1 && height == image.getHeight() - 1) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 0; j++) {
                    dasar.setElmt(i, j, image.getRGB(width - 3 + j, height - 3 + i));
                }
            }
        }

        return dasar;
    }

    public static Matrix matrixpinggir(int height, int width, BufferedImage image) {
        Matrix dasar = new Matrix(4, 4);
        if (height == 0) {
            if (width == 0) {
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        dasar.setElmt(i, j, image.getRGB(j, i));
                    }
                }
            } else if (width == image.getWidth() - 2) {
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        dasar.setElmt(i, j, image.getRGB(width - 2 + j, i));
                    }
                }
            } else {
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        dasar.setElmt(i, j, image.getRGB(width - 1 + j, i));
                    }
                }
            }
        } else if (width == 0) {
            if (height == 0) {
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        dasar.setElmt(i, j, image.getRGB(j, i));
                    }
                }
            } else if (height == image.getHeight() - 2) {
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        dasar.setElmt(i, j, image.getRGB(j, height - 2 + i));
                    }
                }
            } else {
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        dasar.setElmt(i, j, image.getRGB(j, height - 1 + i));
                    }
                }
            }
        } else if (height == image.getHeight() - 1) {
            if (width == 0) {
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        dasar.setElmt(i, j, image.getRGB(j, height - 3 + i));
                    }
                }
            } else if (width == image.getWidth() - 2) {
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        dasar.setElmt(i, j, image.getRGB(width - 2 + j, height - 3 + i));
                    }
                }
            } else {
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        dasar.setElmt(i, j, image.getRGB(width - 1 + j, height - 3 + i));
                    }
                }
            }
        } else if (width == image.getWidth() - 1) {
            if (height == 0) {
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        dasar.setElmt(i, j, image.getRGB(width - 3 + j, i));
                    }
                }
            } else if (height == image.getHeight() - 2) {
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        dasar.setElmt(i, j, image.getRGB(width - 3 + j, height - 2 + i));
                    }
                }
            } else {
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        dasar.setElmt(i, j, image.getRGB(width - 3 + j, height - 1 + i));
                    }
                }
            }
        }

        return dasar;
    }

    public static Matrix matrixtengah(int height, int width, BufferedImage image) {
        Matrix dasar = new Matrix(4, 4);
        if (height == image.getHeight() - 2 && width == image.getWidth() - 2) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    dasar.setElmt(i, j, image.getRGB(width - 2 + j, height - 2 + i));
                }
            }
        } else if (height == image.getHeight() - 2) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    dasar.setElmt(i, j, image.getRGB(width - 1 + j, height - 2 + i));
                }
            }
        } else if (width == image.getWidth() - 2) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    dasar.setElmt(i, j, image.getRGB(width - 2 + j, height - 1 + i));
                }
            }
        } else {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    dasar.setElmt(i, j, image.getRGB(width - 1 + j, height - 1 + i));
                }
            }
        }
        return dasar;
    }

    public static Matrix Warna(Matrix matrix, String s) {
        Matrix warna = new Matrix(matrix.getRowEff(), matrix.getColEff());
        for (int i = 0; i < matrix.getRowEff(); i++) {
            for (int j = 0; j < matrix.getColEff(); j++) {
                int pixel = (int) matrix.getElmt(i, j);
                if (s == "merah") {
                    warna.setElmt(i, j, (pixel >> 16) & 0xFF);
                } else if (s == "hijau") {
                    warna.setElmt(i, j, (pixel >> 8) & 0xFF);
                } else {
                    warna.setElmt(i, j, pixel & 0xFF);
                }
            }
        }

        return warna;
    }

    public static int bicubicInterpolate(BufferedImage image, double x, double y) {
        int width = image.getWidth();
        int height = image.getHeight();
        int Ipixel = 0;
        int tinggi = (int) Math.floor(x);
        int lebar = (int) Math.floor(y);
        Matrix dasar = new Matrix(4, 4);
        int red = 0, green = 0, blue = 0;

        if ((tinggi == 0 && lebar == 0) || (tinggi == 0 && lebar == width - 1) || (tinggi == height - 1 && lebar == 0)
                || (tinggi == height - 1 && lebar == width - 1)) {
            dasar = matrixpojok(tinggi, lebar, image);
        } else if ((tinggi == 0 && lebar > 0) || (tinggi > 0 && lebar == 0) || (lebar == width - 1 && tinggi > 0)
                || (tinggi == height - 1 && lebar > 0)) {
            dasar = matrixpinggir(tinggi, lebar, image);
        } else {
            dasar = matrixtengah(tinggi, lebar, image);
        }
        Matrix merah = Warna(dasar, "merah");
        Matrix hijau = Warna(dasar, "hijau");
        Matrix biru = Warna(dasar, "biru");

        red += (int) BicubicSpline.spline(merah, x - tinggi, y - lebar);
        green += (int) BicubicSpline.spline(hijau, x - tinggi, y - lebar);
        blue += (int) BicubicSpline.spline(biru, x - tinggi, y - lebar);

        Ipixel = (0xFF << 24) |
                ((int) Math.round(red) << 16) |
                ((int) Math.round(green) << 8) |
                (int) Math.round(blue);
        return Ipixel;
    }

    public static void main(String[] args) {
        try {
            // Load the image
            BufferedImage inputImage = ImageIO.read(new File("input.png"));

            int newWidth = 4 * inputImage.getWidth();
            int newHeight = 4 * inputImage.getHeight();
            BufferedImage interpolatedImage = new BufferedImage(newWidth, newHeight, inputImage.getType());

            for (int i = 0; i < newHeight; i++) {
                for (int j = 0; j < newWidth; j++) {
                    double y = (double) j / 4;
                    double x = (double) i / 4;

                    int Ipixel = bicubicInterpolate(inputImage, x, y);
                    interpolatedImage.setRGB(j, i, Ipixel);
                }
                try {
                    ImageIO.write(interpolatedImage, "png", new File("output.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
