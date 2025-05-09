public class IntegerToEnglishWords {
    String[] below_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = {"", " Thousand ", " Million ", " Billion "};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        int i = 0;
        StringBuilder res = new StringBuilder();

        while (num > 0) { //100 000
            int triplet = num % 1000;

            if (triplet > 0) {
                res.insert(0, helper(triplet).trim() + thousands[i]);
            }

            num = num / 1000;
            i++;
        }
        return res.toString().trim();
    }

    private String helper(int num) {
        StringBuilder res = new StringBuilder();

        if (num < 20) {
            res.append(below_20[num]);
        } else if (num < 100) {
            res.append(tens[num / 10]).append(" ").append(below_20[num % 10]);
        } else {
            res.append(below_20[num / 100]).append(" Hundred ").append(helper(num % 100));
        }
        return res.toString();
    }
}

//TC: O(1), SC: O(1)
