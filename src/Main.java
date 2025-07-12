
import week_2.week2_delivery;
import week_2.week2_secretCode;
import week_3.week3_gameMap;
import week_3.week3_server;
import week_4.week4_electric;
import week_4.week4_maze;
import week_5.week5_crain;
import week_5.week5_joystick;
import week_6.week6_emoticon;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){

        int[][] users = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
        int[] emoticon = {1300, 1500, 1600, 4900};


        week6_emoticon a = new week6_emoticon();
        System.out.println(Arrays.toString(a.solution(users, emoticon)));
    }
}