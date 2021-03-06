package lss;

import java.io.BufferedReader;
import java.io.IOException;

public class Buff implements Common {

    int AC;
    int ST[] = new int[ST_LIST.length];
    int[] element_resist = new int[ELEM_LIST.length];
    int[] ELEM_DMG_SHORT = new int[ELEM_LIST.length];
    int[] ELEM_DMG_LONG = new int[ELEM_LIST.length];
    int HP;
    int MP;
    int HPR;
    int MPR;
    int DMG_SHORT;
    int DMG_LONG;
    int DMG_MAGIC;
    int HIT_SHORT;
    int HIT_LONG;
    int HIT_MAGIC;
    int CRI_SHORT;
    int CRI_LONG;
    int CRI_MAGIC;
    int SP;
    int DR;
    int MR;
    int ER;
    double r_weight;
    int c_weight;
    String effect = "";

    int PVP;

    int[] ailment = new int[AILMENT_LIST.length];

    public void loadOption(BufferedReader reader) throws IOException {
        reader.reset();
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("AC=")) {
                AC = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("STR=")) {
                ST[STR] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("DEX=")) {
                ST[DEX] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("CON=")) {
                ST[CON] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("INT=")) {
                ST[INT] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("WIS=")) {
                ST[WIS] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("CHA=")) {
                ST[CHA] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("FIRE=")) {
                element_resist[FIRE] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("EARTH=")) {
                element_resist[EARTH] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("WIND=")) {
                element_resist[WIND] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("WATER=")) {
                element_resist[WATER] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("HP=")) {
                HP = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("MP=")) {
                MP = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("HPR=")) {
                HPR = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("MPR=")) {
                MPR = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("�ǉ��Ō�=")) {
                DMG_SHORT = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("�|�Ō��l=")) {
                DMG_LONG = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("�U������=")) {
                HIT_SHORT = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("�|������=")) {
                HIT_LONG = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("���@����=")) {
                HIT_MAGIC = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("SP=")) {
                SP = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("DR=")) {
                DR = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("MR=")) {
                MR = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("�d�ʌy��=")) {
                r_weight = Double.parseDouble(line.split("=")[1]);
            }
            if (line.startsWith("�����d��=")) {
                c_weight = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("����=")) {
                effect = line.split("=")[1];
            }
            if (line.startsWith("�X�^��=")) {
                ailment[STUN] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("�È�=")) {
                ailment[DARKNESS] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("�z�[���h=")) {
                ailment[HOLD] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("����=")) {
                ailment[FREEZE] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("�Ή�=")) {
                ailment[STONE] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("����=")) {
                ailment[SLEEP] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("���|=")) {
                ailment[TERROR] = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("�ߋ����N���e�B�J��=")) {
               CRI_SHORT = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("�������N���e�B�J��=")) {
               CRI_LONG = Integer.parseInt(line.split("=")[1]);
            }
            if (line.startsWith("���@�N���e�B�J��=")) {
               CRI_MAGIC = Integer.parseInt(line.split("=")[1]);
            }

        }
    }
}
