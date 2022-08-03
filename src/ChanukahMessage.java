public class ChanukahMessage
{
    private int happyLength;
    private int chanukahLength;
    private Letter[] happy;
    private Letter[] chanukah;

    public ChanukahMessage()
    {
        happyLength = 5;
        chanukahLength = 8;
        happy = new Letter[happyLength];
        chanukah = new Letter[chanukahLength];
        setHappyChanukah();
    }

    public void setHappyChanukah()
    {

        int offset = 0;
        Letter H = new Letter("H", (offset += 5));
        Letter A = new Letter("A", (offset += 5));
        Letter P = new Letter("P", (offset += 5));
        Letter P2 = new Letter("P", (offset += 5));
        Letter Y = new Letter("Y", (offset + 5));

        offset = 0;
        Letter C = new Letter("C", (offset += 5));
        Letter H2 = new Letter("H", (offset += 5));
        Letter A2 = new Letter("A", (offset += 5));
        Letter N = new Letter("N", (offset += 5));
        Letter U = new Letter("U", (offset += 5));
        Letter K = new Letter("K", (offset += 5));
        Letter A3 = new Letter("A", (offset += 5));
        Letter H3 = new Letter("H", (offset + 5));

        happy[0] = H;
        happy[1] = A;
        happy[2] = P;
        happy[3] = P2;
        happy[4] = Y;

        chanukah[0] = C;
        chanukah[1] = H2;
        chanukah[2] = A2;
        chanukah[3] = N;
        chanukah[4] = U;
        chanukah[5] = K;
        chanukah[6] = A3;
        chanukah[7] = H3;
    }

    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        for (Letter letter : happy)
        {
            builder.append(letter);
        }
        builder.append("\n");
        for (Letter letter : chanukah)
        {
            builder.append(letter);
        }
        return builder.toString();
    }

    public static void main(String[] args)
    {
        ChanukahMessage message = new ChanukahMessage();
        System.out.println(message);
    }
}
