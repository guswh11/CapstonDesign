package edu.skku.capstone.justpay;

public class personal_item {


        private String name;
        private int pay;
        private int number;

        public personal_item(String name, int pay, int number)
        {
            this.name = name;       // Must refer to instance variables that have
            this.pay = pay;         // the same name as constructor parameters
            this.number = number;
        }
        public String getName() {
            return name;
        }
        public int getPay() {
            return pay;
        }
        public int getNumber() {
            return number;
        }


}
