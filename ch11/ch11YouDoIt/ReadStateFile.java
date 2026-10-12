// Bill Ruben
// p.476

import java.nio.file.*;
import java.io.*;
import java.nio.file.attribute.*;
import static java.nio.file.StandardOpenOption.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Scanner;

public class ReadStateFile {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String fileName;
        System.out.print("Enter name of file to use >> ");
        fileName = kb.nextLine();
        fileName = "" + fileName;
        Path file = Paths.get(fileName);
        final String id_format = "000";
        final String name_format = "          ";
        final int name_length = name_format.length();
        final String home_state = "WI";
        final String balance_format = "0000.00";
        String delimiter = ",";
        String s = id_format + delimiter + name_format +
                delimiter + home_state + delimiter + balance_format +
                System.getProperty("line.separator");
        final int recsize = s.length();
        byte data[] = s.getBytes();
        final String empty_acct = "000";
        String[] array = new String[4];
        double balance;
        double total = 0;
        try
        {
            BasicFileAttributes attr =
             Files.readAttributes(file, BasicFileAttributes.class);
            System.out.println("\nAttributes of the file:");
            System.out.println("Creation time " + attr.creationTime());
            System.out.println("Size " + attr.size());
        }
        catch (IOException e)
        {
            System.out.println("IO Exception");
        }
        try
        {
            InputStream iStream = new
                BufferedInputStream(Files.newInputStream(file));
            BufferedReader reader = new 
              BufferedReader(new InputStreamReader(iStream));
            System.out.println(("\nAll non-default records:\n"));
            s = reader.readLine();
            while(s != null)
            {
                array = s.split(delimiter);
                if(!array[0].equals(empty_acct))
                {
                    balance = Double.parseDouble(array[3]);
                    System.out.println("ID #" + array[0] + "  " +
                      array[1] + " " + array[2] + " $" + array[3]);
                    total += balance;
                }
                s = reader.readLine();
            }
            System.out.println("Total of all balances is $" + total);
            reader.close();
        }
        catch(Exception e)
        {
            System.out.println("Message: " + e);
        }
        try
        {
            FileChannel fc = 
             (FileChannel)Files.newByteChannel(file, READ);
            ByteBuffer buffer = ByteBuffer.wrap(data);
            int findAcct;
            System.out.print("\nEnter account to seek >> ");
            findAcct = kb.nextInt();
            fc.position(findAcct * recsize);
            fc.read(buffer);
            s = new String(data);
            System.out.println("Desired record: " + s);
        }
        catch(Exception e)
        {
            System.out.println("Message: " + e);
        }
    }
}