import java.util.Random;

/**
 * Class to form letters contained in "HAPPY CHANUKAH"
 * CODE IS ADAPTED FROM PROFESSOR MANE'S PYTHON IMPLEMENTATION
 */
public class Letter
{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";

    private int height;
    private int width;
    private int middleRow;
    private int middleCol;

    private String[][] letter;
    private String color;
    private int space; // used to calculate offset so letters aren't stacked on top of each other

    public Letter(String character, int offset)
    {
        height = 7;
        width = 5;
        middleCol = width / 2;
        middleRow = height / 2;
        letter = new String[height][width];
        space = offset;
        setColor();
        setLetter(character);
    }

    /**
     * Randomly select a color from Colors enum
     */
    private void setColor()
    {
        Random rand = new Random();
        int uniformNumber = rand.nextInt(Colors.values().length);
        color = Colors.values()[uniformNumber].toString();
    }

    /**
     * make the letter
     *
     * @param character: the letter we are trying to make
     */
    private void setLetter(String character)
    {
        switch (character)
        {
            case "H":
                letter = makeH();
                break;
            case "A":
                letter = makeA();
                break;
            case "P":
                letter = makeP();
                break;
            case "Y":
                letter = makeY();
                break;
            case "C":
                letter = makeC();
                break;
            case "N":
                letter = makeN();
                break;
            case "U":
                letter = makeU();
                break;
            case "K":
                letter = makeK();
                break;
        }
    }

    /**
     * Each letter is a 2D array, and this fills 2D array background with ANSI_BLACK color
     */
    public void reset()
    {
        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
            {
                letter[i][j] = ANSI_BLACK;
            }
        }
    }

    /**
     * Make H - fill in relevant row-column intersections of 2D list with randomly selected color
     *
     * @return 2D list containing H
     */
    public String[][] makeH()
    {
        reset();
        for (int i = 0; i < letter.length; i++)
        {
            for (int j = 0; j < letter[i].length; j++)
            {
                if (j == 0 || j == width - 1)
                {
                    letter[i][j] = color;
                } else if (i == middleCol + 1)
                {
                    letter[i][j] = color;
                }
            }
        }

        return letter;
    }

    /**
     * Make A - fill in relevant row-column intersections of 2D list with randomly selected color
     *
     * @return 2D list containing A
     */
    public String[][] makeA()
    {
        reset();
        letter[0][middleCol] = color;
        letter[1][middleCol - 1] = color;
        letter[1][middleCol + 1] = color;
        for (int i = middleRow - 1; i < height; i++)
        {
            letter[i][0] = color;
            letter[i][middleCol * 2] = color;
        }
        for (int j = 0; j < width; j++)
        {
            letter[middleRow][j] = color;
        }

        return letter;
    }

    /**
     * Make P - fill in relevant row-column intersections of 2D list with randomly selected color
     *
     * @return 2D list containing P
     */
    public String[][] makeP()
    {
        reset();
        for (int i = 0; i < letter.length; i++)
        {
            for (int j = 0; j < letter[i].length; j++)
            {
                if (i == middleCol || j == 0 || i == 0)
                {
                    letter[i][j] = color;
                } else if (j == width - 1 && i < middleCol + 1)
                {
                    letter[i][j] = color;
                }
            }
        }

        return letter;
    }

    /**
     * Make Y - fill in relevant row-column intersections of 2D list with randomly selected color
     *
     * @return 2D list containing Y
     */
    public String[][] makeY()
    {
        reset();
        int widthPosition = width - 1;
        for (int i = 0; i < middleCol; i++)
        {
            letter[i][i] = color;
            letter[i][widthPosition] = color;
            widthPosition--;
        }
        for (int i = middleCol; i < letter.length; i++)
        {
            for (int j = 0; j < letter[i].length; j++)
            {
                if (j == middleCol)
                {
                    letter[i][j] = color;
                }
            }
        }
        return letter;
    }

    /**
     * Make C - fill in relevant row-column intersections of 2D list with randomly selected color
     *
     * @return 2D list containing C
     */
    public String[][] makeC()
    {
        reset();
        for (int i = 0; i < letter.length; i++)
        {
            for (int j = 0; j < letter[i].length; j++)
            {
                if (j == 0 || i == 0 || i == height - 1)
                {
                    letter[i][j] = color;
                }
            }
        }
        return letter;

    }

    /**
     * Make N - fill in relevant row-column intersections of 2D list with randomly selected color
     *
     * @return 2D list containing N
     */
    public String[][] makeN()
    {
        reset();
        int row = middleRow - 1;
        int col = 1;
        while (row <= 4)
        {
            letter[row][col] = color;
            row++;
            col++;
        }
        for (int i = 0; i < letter.length; i++)
        {
            for (int j = 0; j < letter[i].length; j++)
            {
                if (j == 0 || j == width - 1)
                {
                    letter[i][j] = color;
                }
            }
        }

        return letter;
    }

    /**
     * Make U - fill in relevant row-column intersections of 2D list with randomly selected color
     *
     * @return 2D list containing U
     */
    public String[][] makeU()
    {
        reset();
        for (int i = 0; i < letter.length; i++)
        {
            for (int j = 0; j < letter[i].length; j++)
            {
                if (j == 0 || j == width - 1 || i == height - 1)
                {
                    letter[i][j] = color;
                }
            }
        }

        return letter;
    }

    /**
     * Make K - fill in relevant row-column intersections of 2D list with randomly selected color
     *
     * @return 2D list containing K
     */
    public String[][] makeK()
    {
        reset();
        for (int i = 0; i < letter.length; i++)
        {
            for (int j = 0; j < letter[i].length; j++)
            {
                if (j == 0)
                {
                    letter[i][j] = color;
                } else if (i + j == width - 1)
                {
                    letter[i][j] = color;
                } else if (i - j == 2)
                {
                    letter[i][j] = color;
                }
            }
        }
        return letter;
    }

    /**
     * Loop through 2D list containing letter, print * after each color (intersection) in 2D list to print * in that color
     *
     * @return String of that letter with asterisks forming the letter
     */
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < letter.length; i++)
        {
            for (int k = 0; k < space; k++)
            {
                builder.append(" ");
            }
            for (int j = 0; j < letter[i].length; j++)
            {
                builder.append(letter[i][j]).append(":");
            }
            builder.append("\n");
        }
        builder.append("\n");
        builder.append(ANSI_RESET);
        return builder.toString();
    }
}
