package com.locked_me;

 import org.jetbrains.annotations.NotNull;
 import java.io.File;
 import java.io.FileOutputStream;
 import java.util.*;


public class LockedMe  {
    static final String projectFilesPath="C:\\Source\\javaFS\\LockedMeFiles";
    static  String errorMessage="Some problem occurred, please contact: admin@LockedMe.com";

    public static void main(String[] args) {
        int choice;
        Scanner obj=new Scanner (System.in);

        do{
            displayMenu();
            System.out.println ("Enter Your choice:");
            choice= Integer.parseInt (obj.nextLine ());
            switch(choice)
            {
                case 1: getAllFiles();
                break;
                case 2: addAFile(obj);
                break;
                case 3: deleteFile(obj);
                break;
                case 4: searchFile(obj);
                break;
                case 5: System.exit (0);
                break;
                default:
                    System.out.println ("Invalid Option");
                    break;
            }

        }
        while (choice>0);
        obj.close();

    }

    /**
     * displays menu
     */
    public  static void displayMenu()
    {

        System.out.println ("====================================================================================================================");
        System.out.println ("\t\t\t\t\t\t\t\t\tWelcome to LockedMe.com ");
        System.out.println ("\t\t\t\t\t\t\t\tApplication Name: LockedMe.com");
        System.out.println ("\t\t\t\t\t\t\t\t\tDeveloped by: Madhuri Ganta");
        System.out.println ("====================================================================================================================");
        System.out.println ("\t\t\t1. Display All the Files");
        System.out.println ("\t\t\t2. Add a new File");
        System.out.println ("\t\t\t3. Delete a File");
        System.out.println ("\t\t\t4. Search a File");
        System.out.println ("\t\t\t5. Exit\n");


    }
    /**
     * This function is for to get all the  files in directory
     */
    public static void getAllFiles()
    {
        try
        {
            File folder = new File(projectFilesPath);
            File[] listOfFiles = folder.listFiles();
            Arrays.sort(listOfFiles);
            if(listOfFiles.length==0)
            {
                System.out.println ("No Files exist in the directory");
            }
            else
            {
                for (var file : listOfFiles)
                {
                    System.out.println(file.getName());
                }

            }
        }
        catch(Exception ex)
        {
            System.out.println (errorMessage);
        }

    }

    /**
     * This method is to create file in Folder and writing text in that folder.
     */
    public static void addAFile(Scanner obj)
    {
       // Scanner obj=new Scanner (System.in);
        try
        {
            System.out.println ("Enter File name: ");
            String path = projectFilesPath+"\\"+obj.nextLine ();
            File fileName=new File (path);
            boolean exists = fileName.exists ();
            if(exists) {
                System.out.println ("file already exists! "+fileName);
            }
            else
            {
                FileOutputStream fos=new FileOutputStream (path);
                System.out.println ("Enter File content :");
                String str=obj.nextLine ()+"\n";
                byte[] b =str.getBytes();
                fos.write (b);
                fos.close ();
                System.out.println ("File Created Successfully");

            }

        }
        catch(Exception ex)
        {
            System.out.println (errorMessage);
        }

    }

    /**
     * This method will delete based on provided file name
     */
    public static void deleteFile(@NotNull Scanner obj)
    {
        String fileName;
      //  Scanner obj=new Scanner (System.in);
        System.out.println ("Enter File name to be delete: ");
        fileName = obj.nextLine ();
        File file = new File(projectFilesPath+"\\"+fileName);
        try {

            if (file.exists ())
            {
                file.delete ();
                System.out.println (fileName+" is deleted successfully!");
            }
            else
                System.out.println ("File not found");

        }
        catch (Exception ex)
        {
            System.out.println (errorMessage);
        }
    }

    /**
     * This method will search file in the folder
     */
    public static void searchFile(Scanner obj)
    {
       // Scanner obj=new Scanner (System.in);
        try {
            String fileName;
            File folder = new File (projectFilesPath);
            File[] listOfFiles = folder.listFiles ();
            LinkedList<String> fileNames= new LinkedList<String> ();

            for(var file: listOfFiles)
                fileNames.add(file.getName ());
            System.out.println ("List of files in the folder: "+ fileNames);
            System.out.println ("Enter the File name to be search: ");
            fileName = obj.nextLine ();
            if(fileNames.contains (fileName))
            {
                System.out.println ("File is available: "+ fileName);
            }
            else
                System.out.println ("File is not available");


//            if(Arrays.stream(listOfFiles).anyMatch (f -> f.getName ().equals (fileName)))
//                System.out.println ("File is available: "+ fileName);
//            else
//                System.out.println ("File is not available");


        }
        catch(Exception ex)
        {
            System.out.println (errorMessage);
        }
//        finally {
//           // obj.close();
//        }

    }

}

