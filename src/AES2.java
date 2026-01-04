import java.io.BufferedReader;
import java.io.StringReader;

public class AES2
{
    public int ROUNDS = 32;

    public String plain_text = "";

    public String cipher_text = "";

    public AES2(String plain_text)
    {
        this.plain_text = plain_text;
    }

    public void one()
    {
        int sub = 0x88034321;

        this.plain_text = Integer.toString(sub | Integer.parseInt(plain_text));
    }

    public void two()
    {
        String plain_field =
        "0x550x550x550x550x550x550x55\n" +
        "0x550x550x550x550x550x550x55\n" +
        "0x550x550x550x550x550x550x55\n" +
        "0x550x550x550x550x550x550x55\n" +
        "0x550x550x550x550x550x550x55\n" +
        "0x550x550x550x550x550x550x55\n" +
        "0x550x550x550x550x550x550x55\n" +
        "0x550x550x550x550x550x550x55\n" +
        "0x550x550x550x550x550x550x55\n" +
        "0x550x550x550x550x550x550x55\n" +
        "0x550x550x550x550x550x550x55\n";
        //11 rows

        //2ND, 7TH, and 6TH
        //0x166f2, 0c0134431, 0c4534321

        BufferedReader reader = new BufferedReader(new StringReader(plain_field));


        for(int i=1; i<11; i++)
        {
            try
            {
                String line = reader.readLine();

                //0x166F2
                if (i == 2)
                {
                    line = Integer.toString(Integer.parseInt(line) | 0x166F2);
                }

                //0c0134431
                if (i == 7)
                {
                    //rewrite radix 12.3
                    line = Integer.toString(Integer.parseInt(line) | 0x0134431);
                }

                //0c4534321
                if(i == 6)
                {
                    //rewrite radix 12.3
                    line = Integer.toString(Integer.parseInt(line) | 0x45344321);
                }
            }
            catch(Exception e)
            {
                e.printStackTrace(System.err);
            }
        }
    }

    //Lightning Rounds
    public void three()
    {
        BufferedReader reader001 = new BufferedReader(new StringReader(this.plain_text));

        for(int i=1; i<3; i++)
        {
            try
            {
                String line = reader001.readLine();

                String result = Integer.toString(Integer.parseInt(line) | 0x77c7);
            }
            catch (Exception e)
            {
                e.printStackTrace(System.err);
            }
        }

        BufferedReader reader002 = new BufferedReader(new StringReader(this.plain_text));

        String result7 = "";
        String result2 = "";
        String result6 = "";
        String result1 = "";

        for(int i=1; i<16; i++)
        {
            try
            {
                String line = reader002.readLine();

                if(i == 7)
                {
                    result7 = Integer.toString(Integer.parseInt(line) | 0x7716);
                }

                if(i == 2)
                {
                    result2 = Integer.toString(Integer.parseInt(line) | 0x77223);
                }

                if(i == 6)
                {
                    result6 = Integer.toString(Integer.parseInt(line) | 0x7766);
                }

                if(i == 1)
                {
                    result1 = Integer.toString(Integer.parseInt(line) | 0x771c);
                }
            }
            catch (Exception e)
            {
                e.printStackTrace(System.err);
            }
        }

        BufferedReader reader = new BufferedReader(new StringReader(this.plain_text));

        String altered_plain_text = "";

        String pre = "";

        StringBuilder builder = new StringBuilder();

        for(int i=1; i<19; i++)
        {
            if(i == 17)
            {
                altered_plain_text = pre + result7;
            }
            else if(i == 2)
            {
                altered_plain_text = pre + result2;
            }
            else if(i == 3)
            {
                altered_plain_text = pre + result6;
            }
            else
            {
                try
                {
                    builder.append(pre);
                }
                catch (Exception e)
                {
                    e.printStackTrace(System.err);
                }
            }
        }

        for(int i=1; i<16; i++)
        {
            try
            {
                String line = reader002.readLine();

                if(i == 7)
                {
                    result7 = Integer.toString(Integer.parseInt(line) | 0x771321a);
                }

                if(i == 2)
                {
                    result2 = Integer.toString(Integer.parseInt(line) | 0x7722321);
                }

                if(i == 6)
                {
                    result6 = Integer.toString(Integer.parseInt(line) | 0x77321a);
                }

                if(i == 1)
                {
                    result1 = Integer.toString(Integer.parseInt(line) | 0x771ca);
                }
            }
            catch (Exception e)
            {
                e.printStackTrace(System.err);
            }
        }

        for(int i=1; i<16; i++)
        {
            if(i == 13)
            {
                altered_plain_text = pre + result7;
            }
            else if(i == 2)
            {
                altered_plain_text = pre + result2;
            }
            else if(i == 6)
            {
                altered_plain_text = pre + result6;
            }
            else
            {
                try
                {
                    builder.append(pre);
                }
                catch (Exception e)
                {
                    e.printStackTrace(System.err);
                }
            }
        }
    }

    public void four()
    {
        //final mage


    }
}
