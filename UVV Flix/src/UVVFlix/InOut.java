package UVVFlix;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class InOut {

    public static String leString(String frase, String img) {
        String Entrada;
        Icon c = new ImageIcon(img);

        Entrada = (String) JOptionPane.showInputDialog(
                null,
                frase,
                "",
                JOptionPane.QUESTION_MESSAGE,
                c,
                null,
                ""
        );

        return Entrada;
    }

    public static byte leByte(String frase, String img) {
        byte num = 0;
        String Entrada;
        boolean ERRO;
        Icon c = new ImageIcon(img);

        do {
            try {
                Entrada = (String) JOptionPane.showInputDialog(
                        null,
                        frase,
                        "",
                        JOptionPane.QUESTION_MESSAGE,
                        c,
                        null,
                        ""
                );

                num = Byte.parseByte(Entrada);
                ERRO = false;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                        null,
                        "VALOR DEVE SER UM NUMERO DO TIPO BYTE",
                        "   >>>      ERRO     <<<",
                        JOptionPane.ERROR_MESSAGE,
                        c
                );

                ERRO = true;
            }
        } while (ERRO);

        return num;
    }

    public static short leShort(String frase, String img) {
        short num = 0;
        String Entrada;
        boolean ERRO;
        Icon c = new ImageIcon(img);

        do {
            try {
                Entrada = (String) JOptionPane.showInputDialog(
                        null,
                        frase,
                        "",
                        JOptionPane.QUESTION_MESSAGE,
                        c,
                        null,
                        ""
                );

                num = Short.parseShort(Entrada);
                ERRO = false;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                        null,
                        "VALOR DEVE SER UM NUMERO DO TIPO SHORT",
                        "   >>>      ERRO     <<<",
                        JOptionPane.ERROR_MESSAGE,
                        c
                );

                ERRO = true;
            }
        } while (ERRO);

        return num;
    }

    public static int leInt(String frase, String img) {
        int num = 0;
        String Entrada;
        boolean ERRO;
        Icon c = new ImageIcon(img);

        do {
            try {
                Entrada = (String) JOptionPane.showInputDialog(
                        null,
                        frase,
                        "",
                        JOptionPane.QUESTION_MESSAGE,
                        c,
                        null,
                        ""
                );

                num = Integer.parseInt(Entrada);
                ERRO = false;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(
                        null,
                        "VALOR DEVE SER UM NUMERO DO TIPO INTEIRO ",
                        "   >>>      ERRO     <<<",
                        JOptionPane.ERROR_MESSAGE,
                        c
                );

                ERRO = true;
            }
        } while (ERRO);

        return num;
    }

    public static long leLong(String frase, String img) {
        long num = 0;
        String Entrada;
        boolean ERRO;
        Icon c = new ImageIcon(img);

        do {
            try {
                Entrada = (String) JOptionPane.showInputDialog(
                        null,
                        frase,
                        "",
                        JOptionPane.QUESTION_MESSAGE,
                        c,
                        null,
                        ""
                );

                num = Long.parseLong(Entrada);
                ERRO = false;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(
                        null,
                        "VALOR DEVE SER UM NUMERO DO TIPO LONG ",
                        "   >>>      ERRO     <<<",
                        JOptionPane.ERROR_MESSAGE,
                        c
                );

                ERRO = true;
            }
        } while (ERRO);

        return num;
    }

    public static float leFloat(String frase, String img) {
        float num = 0;
        String Entrada;
        boolean ERRO;
        Icon c = new ImageIcon(img);

        do {
            try {
                Entrada = (String) JOptionPane.showInputDialog(
                        null,
                        frase,
                        "",
                        JOptionPane.QUESTION_MESSAGE,
                        c,
                        null,
                        ""
                );

                num = Float.parseFloat(Entrada);
                ERRO = false;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(
                        null,
                        "VALOR DEVE SER UM NUMERO DO TIPO FLOAT",
                        "   >>>      ERRO     <<<",
                        JOptionPane.ERROR_MESSAGE,
                        c
                );

                ERRO = true;
            }
        } while (ERRO);

        return num;
    }

    public static double leDouble(String frase, String img) {
        double num = 0;
        String Entrada;
        boolean ERRO;
        Icon c = new ImageIcon(img);

        do {
            try {
                Entrada = (String) JOptionPane.showInputDialog(
                        null,
                        frase,
                        "",
                        JOptionPane.QUESTION_MESSAGE,
                        c,
                        null,
                        ""
                );

                num = Double.parseDouble(Entrada);
                ERRO = false;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(
                        null,
                        "VALOR DEVE SER UM NUMERO DO TIPO DOUBLE",
                        "   >>>      ERRO     <<<",
                        JOptionPane.ERROR_MESSAGE,
                        c
                );

                ERRO = true;
            }
        } while (ERRO);

        return num;
    }

    public static char leChar(String frase, String img) {
        String Entrada;
        boolean ERRO;
        Icon c = new ImageIcon(img);

        do {
            Entrada = (String) JOptionPane.showInputDialog(
                    null,
                    frase,
                    "",
                    JOptionPane.QUESTION_MESSAGE,
                    c,
                    null,
                    ""
            );

            if (Entrada.length() != 0) {
                ERRO = false;
            } else {
                ERRO = true;
            }

        } while (ERRO);

        return Entrada.charAt(0);
    }

    public static void MsgDeErro(String cabecalho, String frase, String img) {
        Icon c = new ImageIcon(img);

        JOptionPane.showMessageDialog(
                null,
                frase,
                cabecalho,
                JOptionPane.ERROR_MESSAGE,
                c
        );
    }

    public static void MsgDeInformacao(String cabecalho, String frase, String img) {
        Icon c = new ImageIcon(img);

        JOptionPane.showMessageDialog(
                null,
                frase,
                cabecalho,
                JOptionPane.INFORMATION_MESSAGE,
                c
        );
    }

    public static void MsgSemIcone(String cabecalho, String frase, String img) {
        Icon c = new ImageIcon(img);

        JOptionPane.showMessageDialog(
                null,
                frase,
                cabecalho,
                JOptionPane.PLAIN_MESSAGE,
                c
        );
    }

    public static void MsgDeAviso(String cabecalho, String frase, String img) {
        Icon c = new ImageIcon(img);

        JOptionPane.showMessageDialog(
                null,
                frase,
                cabecalho,
                JOptionPane.WARNING_MESSAGE,
                c
        );
    }

    void main() {
    }
}