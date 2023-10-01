
import java.util.Scanner;

import iomatrix.*;
import matrix.*;

//tes
public class mainprogram {
    static boolean startprogram = true;

    public static void main(String[] args) {

        // Scanner utama buat main
        Scanner scanner = new Scanner(System.in);
        while (startprogram) {
            boolean isMenu = true;
            System.out.println("===============MENU================");
            System.out.println("1.Sistem Persamaan Linier");
            System.out.println("2.Determinan");
            System.out.println("3.Matriks balikan");
            System.out.println("4.Interpolasi Polinom");
            System.out.println("5.Interpolasi Bicubic Spline");
            System.out.println("6.Regresi Linier Berganda");
            System.out.println("7.Pembesaran size Gambar dengan Bicubic Spline");
            System.out.println("8.KELUAR");
            int opsiMenu = scanner.nextInt();
            // Keluar Program
            if (opsiMenu == 8) {
                System.out.println("Keluar dari program");
                scanner.close();
                startprogram = false;
            }
            // ===SPL=====
            else if (opsiMenu == 1) {
                isMenu = false;
                while (isMenu == false) {
                    Tools.kirimOpsiMethod();
                    int opsiMethod = scanner.nextInt();

                    // Balik Ke Menu
                    if (opsiMethod == 5) {
                        isMenu = true;
                    } else {
                        // SPL METODE GAUSS
                        if (opsiMethod == 1) {
                            System.out.println("Mau input matriks dalam bentuk apa?");
                            System.out.println("1. Keyboard");
                            System.out.println("2. Input File");
                            int opsiInput = scanner.nextInt();
                            if (opsiInput == 1) {
                                Matrix matrix = InputMatrix.inputMatrixKeyboard(scanner);
                                SPL.createMatriksEselon(matrix);
                                SPL.createEselonTereduksi(matrix);
                                OutputMatrix.tulisSolusiGaussJordan(SPL.solutionGaussJordan(matrix), matrix);
                            } else {
                                Matrix matrix = InputMatrix.inputFileMatrix(scanner);
                                SPL.createMatriksEselon(matrix);
                                SPL.createEselonTereduksi(matrix);
                                OutputMatrix.tulisSolusiGaussJordan(SPL.solutionGaussJordan(matrix), matrix);
                            }
                            // Abis ini ada Info Mau dikirim hasilnya ke txt atau nggak, buat Andi
                            System.out.println("Apakah jawaban mau disimpan?");
                            System.out.println("1.iya");
                            System.out.println("2.tidak");
                            int opsiHasil = scanner.nextInt();

                            Tools.pause();
                            // Mau input apapun(simpen dalam txt atau nggak), nanti balik ke Menu
                            isMenu = true;
                        }
                        // SPL METODE GAUSS-JORDAN
                        if (opsiMethod == 2) {
                            System.out.println("Mau input matriks dalam bentuk apa?");
                            System.out.println("1. Keyboard");
                            System.out.println("2. Input File");
                            int opsiInput = scanner.nextInt();
                            if (opsiInput == 1) {
                                Matrix matrix = InputMatrix.inputMatrixKeyboard(scanner);
                                SPL.createMatriksEselon(matrix);
                                SPL.createEselonTereduksi(matrix);
                                OutputMatrix.tulisSolusiGaussJordan(SPL.solutionGaussJordan(matrix), matrix);
                            } else {
                                Matrix matrix = InputMatrix.inputFileMatrix(scanner);
                                SPL.createMatriksEselon(matrix);
                                SPL.createEselonTereduksi(matrix);
                                OutputMatrix.tulisSolusiGaussJordan(SPL.solutionGaussJordan(matrix), matrix);
                            }
                            // Abis ini ada Info Mau dikirim hasilnya ke txt atau nggak, buat Andi
                            System.out.println("Apakah jawaban mau disimpan?");
                            System.out.println("1.iya");
                            System.out.println("2.tidak");
                            int opsiHasil = scanner.nextInt();
                            // Mau input apapun(simpen dalam txt atau nggak), nanti balik ke Menu
                            Tools.pause();
                            isMenu = true;
                        }
                        // SPL METODE MATRIX BALIKAN
                        if (opsiMethod == 3) {
                            System.out.println("Mau input matriks dalam bentuk apa?");
                            System.out.println("1. Keyboard");
                            System.out.println("2. Input File");
                            int opsiInput = scanner.nextInt();
                            if (opsiInput == 1) {
                                Matrix matrix = InputMatrix.inputMatrixKeyboard(scanner);
                                SPL.inverseMatrix(matrix);

                            } else {
                                Matrix matrix = InputMatrix.inputFileMatrix(scanner);
                                SPL.inverseMatrix(matrix);
                            }
                            // Abis ini ada Info Mau dikirim hasilnya ke txt atau nggak, buat Andi
                            System.out.println("Apakah jawaban mau disimpan?");
                            System.out.println("1.iya");
                            System.out.println("2.tidak");
                            int opsiHasil = scanner.nextInt();
                            // Mau input apapun(simpen dalam txt atau nggak), nanti balik ke Menu
                            Tools.pause();
                            isMenu = true;
                        }
                        if (opsiMethod == 4) {
                            System.out.println("Mau input matriks dalam bentuk apa?");
                            System.out.println("1. Keyboard");
                            System.out.println("2. Input File");
                            int opsiInput = scanner.nextInt();
                            if (opsiInput == 1) {
                                Matrix matrix = InputMatrix.inputMatrixKeyboard(scanner);
                                OutputMatrix.tulisSolusi(SPL.Cramer(matrix, false));

                            } else {
                                Matrix matrix = InputMatrix.inputFileMatrix(scanner);
                                OutputMatrix.tulisSolusi(SPL.Cramer(matrix, false));
                            }
                            // Abis ini ada Info Mau dikirim hasilnya ke txt atau nggak, buat Andi
                            System.out.println("Apakah jawaban mau disimpan?");
                            System.out.println("1.iya");
                            System.out.println("2.tidak");
                            int opsiHasil = scanner.nextInt();
                            // Mau input apapun(simpen dalam txt atau nggak), nanti balik ke Menu
                            Tools.pause();
                            isMenu = true;
                        }

                    }

                }

            }
            // ===Determinan=====
            else if (opsiMenu == 2) {
                isMenu = false;
                while (isMenu == false) {

                    System.out.println("5.BALIK KE MENU");
                    int opsiMethod = scanner.nextInt();

                    // Balik Ke Menu
                    if (opsiMethod == 5) {

                        Tools.pause();
                        isMenu = true;
                    }
                }

            }
            // ===Balikan=====
            else if (opsiMenu == 3) {
                isMenu = false;
                while (isMenu == false) {

                    System.out.println("5.BALIK KE MENU");
                    int opsiMethod = scanner.nextInt();

                    // Balik Ke Menu
                    if (opsiMethod == 5) {

                        Tools.pause();
                        isMenu = true;
                    }
                }

            }
            // ===Interpolasi Polinom=====
            else if (opsiMenu == 4) {
                isMenu = false;
                while (isMenu == false) {
                    System.out.println("Mau input matriks dalam bentuk apa?");
                    System.out.println("1. Keyboard");
                    System.out.println("2. Input File");
                    System.out.println("5.BALIK KE MENU");
                    int opsiMethod = scanner.nextInt();

                    // Opsi Input Keyboard
                    if (opsiMethod == 1) {
                        Matrix matrix = InputMatrix.inputInterpolasi(scanner);
                        InterpolasiPolinomial.Interpolasi(matrix,false);

                        Tools.pause();
                        isMenu = true;
                    }
                    if (opsiMethod == 2) {
                        Matrix matrix = InputMatrix.inputFileMatrix(scanner);
                        InterpolasiPolinomial.Interpolasi(matrix, true);
                        Tools.pause();
                        isMenu = true;
                    }

                    // Balik Ke Menu
                    if (opsiMethod == 5) {
                        isMenu = true;
                    }
                }

            }
            // ===Interpolasi Bicubic Spline=====
            else if (opsiMenu == 5) {
                isMenu = false;
                while (isMenu == false) {
                    Tools.kirimOpsiMethod();
                    int opsiMethod = scanner.nextInt();

                    // Balik Ke Menu
                    if (opsiMethod == 5) {
                        Tools.pause();
                        isMenu = true;
                    }
                }

            }
            // ===Regresi Linier Berganda=====
            else if (opsiMenu == 6)

            {
                isMenu = false;
                while (isMenu == false) {
                    System.out.println("Mau input matriks dalam bentuk apa?");
                    System.out.println("1. Keyboard");
                    System.out.println("2. Input File");
                    int opsiInput = scanner.nextInt();
                    if (opsiInput == 1) {
                        InputMatrix.inputRegresiLinierKeyboard(scanner);
                        System.out.println("Apakah jawaban mau disimpan?");
                        System.out.println("1.iya");
                        System.out.println("2.tidak");

                    } else if (opsiInput == 2) {
                        InputMatrix.inputRegresiLinierFile(scanner);
                    } else {
                        System.out.println("Input Tidak Sesuai! Balik ke menu!");
                        Tools.pause();
                        isMenu = true;
                        break;
                    }

                    // Abis ini ada Info Mau dikirim hasilnya ke txt atau nggak, buat Andi
                    System.out.println("Apakah jawaban mau disimpan?");
                    System.out.println("1.iya");
                    System.out.println("2.tidak");
                    int opsiHasil = scanner.nextInt();
                    // Mau input apapun(simpen dalam txt atau nggak), nanti balik ke Menu
                    Tools.pause();
                    isMenu = true;

                }

            }
            // ===Pembesaran Gambar dengan Bicubic SPline=====
            else if (opsiMenu == 7) {
                isMenu = false;
                while (isMenu == false) {

                    int opsiMethod = scanner.nextInt();

                    // Balik Ke Menu
                    if (opsiMethod == 5) {

                        Tools.pause();
                        isMenu = true;
                    }
                }

            }
            // Error handler
            else {
                System.out.println("Input Tidak Sesuai!");
            }

        }

        // Matrix matrix = InputMatrix.inputFileMatrix(scanner);
        // Matrix matrix = InputMatrix.inputMatrixKeyboard(scanner);

        /* Input untuk interpolasi */

        // Menu Interpolasi
        // matrix = InputMatrix.inputInterpolasi(scanner);
        // InterpolasiPolinomial.Interpolasi(matrix);

        // TES REGRESI LINEAR BERGANDA
        // InputMatrix.inputRegresiLinier(scanner);

        // BICUBIC
        // BicubicSpline.splineimg();

        // Menu Cramer
        // OutputMatrix.tulisSolusi(SPL.Cramer(matrix,false));

        // SPL.inverseMatrix(matrix);

        // TES GAUSSJORDAN
        // SPL.createMatriksEselon(matrix);
        // SPL.createEselonTereduksi(matrix);

        // OutputMatrix.tulisSolusiGaussJordan(SPL.solutionGaussJordan(matrix), matrix);
        // OutputMatrix.tulisMatrix(matrix);

        // TES DETERMINAN OBE
        // System.out.println(DeterminanOBE.determinanOBE(matrix));

    }
}
