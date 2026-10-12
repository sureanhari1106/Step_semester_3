public class ThePasswordChecker {

    static class PasswordChecker {
        private final String password;

        public PasswordChecker(String password) {
            this.password = password;
        }

        public String getStrength() {
            int length = password.length();

            if (length < 6) {
                return "Weak";
            } else if (length <= 9) {
                return "Medium";
            } else {
                return "Strong";
            }
        }
    }

    public static void main(String[] args) {
        PasswordChecker pc1 = new PasswordChecker("abcd");
        PasswordChecker pc2 = new PasswordChecker("abcdefgh");
        PasswordChecker pc3 = new PasswordChecker("abcdefghijkl");

        System.out.println(pc1.getStrength());
        System.out.println(pc2.getStrength());
        System.out.println(pc3.getStrength());
    }
}
