public class PasswordChecker
{
    private char[] password;
    private final int passwordMinimalLength, passwordMaximalLength;

    PasswordChecker(char [] password_)
    {
        password = password_;
        passwordMinimalLength = 5;
        passwordMaximalLength = 100;
    }

    private boolean CheckLenght()
    {
        return password.length >= passwordMinimalLength && password.length <= passwordMaximalLength;
    }

    private boolean CheckCapitalLetter()
    {
        for (char character : password) if (Character.isUpperCase(character)) return true;

        return false;
    }

    private boolean CheckSpecialSymbol()
    {
        for (char character : password) if (!Character.isLetterOrDigit(character)) return true;

        return false;
    }

    public boolean CheckPasscodeStrongness()
    {
        System.out.println(CheckLenght());
        System.out.println(CheckCapitalLetter());
        System.out.println(CheckSpecialSymbol());
        return CheckLenght() && CheckCapitalLetter() && CheckSpecialSymbol();
    }
}
