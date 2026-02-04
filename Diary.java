import java.io.FileWriter;
import java.io.FileReader;
import java.util.Scanner;

class Diary {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String diaryPassword = "1234";
        String enterPassword;

        System.out.print("Enter diary password: ");
        enterPassword = sc.nextLine();

        if (!enterPassword.equals(diaryPassword)) {
            System.out.println("Wrong password. Diary is private.");
            return;
        }

        System.out.println("My Personal Diary");
        System.out.println("1. Write diary");
        System.out.println("2. Read diary");
        System.out.print("Choose option: ");

        int diaryChoice = sc.nextInt();
        sc.nextLine();

        if (diaryChoice == 1) {
            try {
                FileWriter diaryFile = new FileWriter("myDiary.txt", true);

                System.out.println("Write diary (type END to save):");
                while (true) {
                    String diaryText = sc.nextLine();
                    if (diaryText.equals("END")) {
                        break;
                    }
                    diaryFile.write(diaryText + "\n");
                }

                diaryFile.write("\n");
                diaryFile.close();

                System.out.println("Diary saved.");

            } catch (Exception e) {
                System.out.println("Error writing diary.");
            }
        }

        else if (diaryChoice == 2) {
            try {
                FileReader diaryRead = new FileReader("myDiary.txt");
                Scanner diaryScan = new Scanner(diaryRead);

                while (diaryScan.hasNextLine()) {
                    System.out.println(diaryScan.nextLine());
                }

                diaryRead.close();
                diaryScan.close();

            } catch (Exception e) {
                System.out.println("Diary not found.");
            }
        }

        else {
            System.out.println("Invalid option.");
        }

        sc.close();
    }
}
