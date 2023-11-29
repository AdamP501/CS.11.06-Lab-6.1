import java.io.*;
import java.util.Scanner;

public class AdventureTime {

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        int challengeOneAnswer = challengeOne("inputOneTwo.txt");
        int challengeTwoAnswer = challengeTwo("inputOneTwo.txt");
        int challengeThreeAnswer = challengeThree("inputThreeFour.txt");
        int challengeFourAnswer = challengeFour("inputThreeFour.txt");
        writeFileAllAnswers("AdventureTime.txt",challengeOneAnswer,challengeTwoAnswer,challengeThreeAnswer,challengeFourAnswer);

    }

    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws IOException {
        int count = 0;
        int[] numbers = readFile(fileName);
        for (int i = 1; i < numbers.length; i++)
        {
            if (numbers[i] > numbers[i-1])
            {
                count++;
            }
        }
        return count;
    }

    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {
        int count = 0;
        int[] numbers = readFile(fileName);
        int sum = numbers[0] + numbers[1] + numbers[2];
        int newSum = 0;
        for (int i = 1; i < numbers.length-2; i++)
        {
            newSum = numbers[i] + numbers[i+1] + numbers[i+2];
            if (newSum > sum)
            {
                count++;
            }
            sum = newSum;
        }
        return count;

    }

    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName) throws FileNotFoundException {
        String[] directions = readFile2(fileName);

        int depth = 0;
        int horizontal = 0;
        String original = "";
        int casted = 0;
        for (int i = 0; i < directions.length; i++)
        {
            if (directions[i].contains("forward"))
                {
                    original = directions[i].substring(directions[i].length()-1);
                    casted = Integer.parseInt(original);
                    horizontal += casted;

                }
            if (directions[i].contains("up"))
                {
                    original = directions[i].substring(directions[i].length()-1);
                    casted = Integer.parseInt(original);
                    depth -= casted;
                }
            if (directions[i].contains("down"))
                {
                    original = directions[i].substring(directions[i].length()-1);
                    casted = Integer.parseInt(original);
                    depth += casted;
                }

        }
        return depth*horizontal;

    }

    /** TODO 4
     *
     * Challenge 4
     *
     * @param filename
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String filename) throws FileNotFoundException {
        String[] directions = readFile2(filename);
        int depth = 0;
        int horizontal = 0;
        String original = "";
        int casted = 0;
        int aim = 0;
        for (int i = 0; i < directions.length; i++)
        {
            if (directions[i].contains("forward"))
            {
                original = directions[i].substring(directions[i].length()-1);
                casted = Integer.parseInt(original);
                horizontal += casted;
                depth += aim*casted;

            }
            if (directions[i].contains("up"))
            {
                original = directions[i].substring(directions[i].length()-1);
                casted = Integer.parseInt(original);
                aim -= casted;

            }
            if (directions[i].contains("down"))
            {
                original = directions[i].substring(directions[i].length()-1);
                casted = Integer.parseInt(original);
                aim += casted;
            }

        }
        return depth*horizontal;
    }

    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    private static String[] readFile2(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        String[] data = new String[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextLine();
        }
        scanner.close();
        return data;
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }

}