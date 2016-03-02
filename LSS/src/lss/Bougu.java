package lss;

import java.io.BufferedReader;
import java.io.IOException;

public class Bougu implements Common {

    Buff op = new Buff();
    Buff op2 = new Buff();
    String name = "";
    String type = "";
    String material = "";
    String equip = "";
    String grade = "";
    int enchant = 0;
    int max_enchant = 0;
    int safety = 0;
    int mr_enchant = 0;
    boolean element_enchant = false;
    String tokusei = "";

    void reset() {

        op = new Buff();
        op2 = new Buff();
        name = "";
        type = "";
        material = "";
        equip = "";
        grade = "";
        enchant = 0;
        safety = 0;
        mr_enchant = 0;
        element_enchant = false;
        tokusei = "";
    }

    public void load(BufferedReader reader) {
        reset();
        if (reader == null) {
            return;
        }
        try {
            reader.mark(1000000);
            reader.reset();
            op.loadOption(reader);
            reader.reset();

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("equip=")) {
                    equip = line.split("=")[1];
                }
                if (line.startsWith("name=")) {
                    name = line.split("=")[1];
                }
                if (line.startsWith("ÀS=")) {
                    safety = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("­»ÀE=")) {
                    max_enchant = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("type=")) {
                    type = line.split("=")[1];
                }
                if (line.startsWith("Þ¿=")) {
                    material = line.split("=")[1];
                }
                if (line.startsWith("O[h=")) {
                    grade = line.split("=")[1];
                }
                if (line.startsWith("MR­»=")) {
                    mr_enchant = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("óÍ­»=")) {
                    element_enchant = Boolean.parseBoolean(line.split("=")[1]);
                }
                if (line.startsWith("Á«=")) {
                    tokusei = line.split("=")[1];
                }
            }
        } catch (IOException | NullPointerException e) {
            System.out.println(e);
        }
    }

    public String getText() {
        String text = "";
        text += "AC" + (op.AC + op2.AC);
        if (op.HP + op2.HP > 0) {
            text += " HP+" + (op.HP + op2.HP);
        }
        if (op.MP + op2.MP > 0) {
            text += " MP+" + (op.MP + op2.MP);
        }
        if (op.HPR + op2.HPR > 0) {
            text += " HP©Rñ+" + (op.HPR + op2.HPR);
        }
        if (op.HPR + op2.HPR < 0) {
            text += " HP©Rñ" + (op.HPR + op2.HPR);
        }
        if (op.MPR + op2.MPR > 0) {
            text += " MP©Rñ+" + (op.MPR + op2.MPR);
        }
        if (op.MPR + op2.MPR < 0) {
            text += " MP©Rñ" + (op.MPR + op2.MPR);
        }
        if (op.ST[STR] + op2.ST[STR] > 0) {
            text += " STR+" + (op.ST[STR] + op2.ST[STR]);
        }
        if (op.ST[DEX] + op2.ST[DEX] > 0) {
            text += " DEX+" + (op.ST[DEX] + op2.ST[DEX]);
        }
        if (op.ST[CON] + op2.ST[CON] > 0) {
            text += " CON+" + (op.ST[CON] + op2.ST[CON]);
        }
        if (op.ST[INT] + op2.ST[INT] > 0) {
            text += " INT+" + (op.ST[INT] + op2.ST[INT]);
        }
        if (op.ST[WIS] + op2.ST[WIS] > 0) {
            text += " WIS+" + (op.ST[WIS] + op2.ST[WIS]);
        }
        if (op.ST[CHA] + op2.ST[CHA] > 0) {
            text += " CHA+" + (op.ST[CHA] + op2.ST[CHA]);
        }
        if (op.ST[STR] < 0) {
            text += " STR" + op.ST[STR];
        }
        if (op.ST[DEX] < 0) {
            text += " DEX" + op.ST[DEX];
        }
        if (op.ST[CON] < 0) {
            text += " CON" + op.ST[CON];
        }
        if (op.ST[INT] < 0) {
            text += " INT" + op.ST[INT];
        }
        if (op.ST[WIS] < 0) {
            text += " WIS" + op.ST[WIS];
        }
        if (op.ST[CHA] < 0) {
            text += " CHA" + op.ST[CHA];
        }
        if (op.d_short + op2.d_short > 0) {
            text += " ÇÁÅ+" + (op.d_short + op2.d_short);
        }
        if (op.HIT_SHORT + op2.HIT_SHORT > 0) {
            text += " U¬÷+" + (op.HIT_SHORT + op2.HIT_SHORT);
        }
        if (op.HIT_LONG + op2.HIT_LONG > 0) {
            text += " |½¦+" + (op.HIT_LONG + op2.HIT_LONG);
        }
        if (op.d_long + op2.d_long > 0) {
            text += " £_[W+" + (op.d_long + op2.d_long);
        }
        if (op.SP + op2.SP > 0) {
            text += " Í+" + (op.SP + op2.SP);
        }
        if (op.SP < 0) {
            text += " Í" + op.SP;
        }
        if (op.element_resist[FIRE] > 0) {
            text += " ÎÌ®«" + op.element_resist[FIRE];
        }
        if (op.element_resist[WATER] > 0) {
            text += " Ì®«" + op.element_resist[WATER];
        }
        if (op.element_resist[WIND] > 0) {
            text += " Ì®«" + op.element_resist[WIND];
        }
        if (op.element_resist[EARTH] > 0) {
            text += " nÌ®«" + op.element_resist[EARTH];
        }
        if (op.MR > 0) {
            text += " @hä+" + (op.MR + op2.MR);
        }
        if (mr_enchant > 0) {
            text += " (­»ÉMR+" + mr_enchant + ")";
        }
        if (op.ailment[STUN] > 0) {
            text += " X^Ï«+" + op.ailment[STUN];
        }
        if (op.ailment[HOLD] > 0) {
            text += " z[hÏ«+" + op.ailment[HOLD];
        }
        if (op.ailment[SLEEP] > 0) {
            text += " °Ï«+" + op.ailment[SLEEP];
        }
        if (op.ailment[FREEZE] > 0) {
            text += " Ï«+" + op.ailment[FREEZE];
        }
        if (op.ailment[STONE] > 0) {
            text += " Î»Ï«+" + op.ailment[STONE];
        }
        if (op.ailment[DARKNESS] > 0) {
            text += " ÃÅÏ«+" + op.ailment[DARKNESS];
        }
        if (!op.effect.equals("")) {
            text += " " + op.effect;
        }
        if (!op2.effect.equals("")) {
            text += " " + op2.effect;
        }
        return text;
    }

    public void checkEnchant() {

        op2 = new Buff();
        
        if (name.contains("Xibp[")) {
            if (name.contains("j³ê½")) {
                if (name.contains("Em")) {
                    switch (enchant) {
                        case 8:
                            op2.d_long++;
                            op2.d_short++;
                            op2.PVP++;
                            op2.HIT_SHORT++;
                            op2.HIT_LONG++;
                        case 7:
                            op2.HP += 5;
                            op2.d_long++;
                            op2.d_short++;
                            op2.PVP++;
                            op2.HIT_SHORT++;
                            op2.HIT_LONG++;
                            op2.AC++;
                        case 6:
                            op2.HP += 5;
                            op2.d_long++;
                            op2.d_short++;
                            op2.HIT_SHORT++;
                            op2.HIT_LONG++;
                        case 5:
                            op2.HP += 5;
                            op2.d_long++;
                            op2.d_short++;
                            op2.HIT_SHORT++;
                            op2.HIT_LONG++;
                        case 4:
                            op2.HP += 5;
                            op2.d_long++;
                            op2.d_short++;
                            op2.HIT_SHORT++;
                            op2.HIT_LONG++;
                            op2.AC--;
                        case 3:
                            op2.HP += 10;
                            op2.AC += 4;
                            System.out.println("u");
                    }
                } else if (name.contains("mb")) {
                    switch (enchant) {
                        case 8:
                            op2.PVP++;
                            op2.SP++;
                            op2.HP += 10;
                            op2.MP += 5;
                        case 7:
                            op2.PVP++;
                            op2.SP++;
                            op2.HP += 5;
                            op2.MP += 5;
                            op2.AC++;
                        case 6:
                            op2.HP += 5;
                            op2.MP += 10;
                        case 5:
                            op2.HP += 5;
                            op2.SP++;
                        case 4:
                            op2.HP += 5;
                            op2.SP++;
                            op2.AC++;
                        case 3:
                            op2.AC -= 3;
                            op2.HP += 20;

                    }
                } else if (name.contains("ÌÍ")) {
                    switch (enchant) {
                        case 8:
                            op2.HP += 10;
                            op2.d_long++;
                            op2.d_short++;
                            op2.PVP++;
                        case 7:
                            op2.HP += 10;
                            op2.AC--;
                            op2.d_long++;
                            op2.d_short++;
                            op2.PVP++;
                        case 6:
                            op2.HP += 5;
                            op2.d_long++;
                            op2.d_short++;
                        case 5:
                            op2.HP += 5;
                            op2.d_long++;
                            op2.d_short++;
                            op2.PVP++;
                        case 4:
                            op2.d_long++;
                            op2.d_short++;
                            op2.HP += 5;
                            op2.AC--;
                        case 3:
                            op2.HP += 30;
                            op2.AC -= 3;
                    }
                } else if (name.contains("@ïR")) {
                    switch (enchant) {
                        case 8:
                            op2.MR++;
                            op2.d_long++;
                            op2.d_short++;
                            op2.PVP++;
                        case 7:
                            op2.HP += 5;
                            op2.MR++;
                            op2.AC--;
                            op2.d_long++;
                            op2.d_short++;
                            op2.PVP++;
                        case 6:
                            op2.HP += 5;
                            op2.MR++;
                            op2.d_long++;
                            op2.d_short++;
                        case 5:
                            op2.HP += 5;
                            op2.d_long++;
                            op2.d_short++;
                            op2.PVP++;
                        case 4:
                            op2.d_long++;
                            op2.d_short++;
                            op2.HP += 5;
                            op2.AC--;
                        case 3:
                            op2.HP += 30;
                            op2.AC -= 3;
                    }
                } else if (name.contains("W") || name.contains("}i") || name.contains("ñ")) {
                    switch (enchant) {
                        case 8:
                            op2.d_long++;
                            op2.d_short++;
                            op2.PVP++;
                        case 7:
                            op2.HP += 5;
                            op2.d_long++;
                            op2.d_short++;
                            op2.PVP++;
                        case 6:
                            op2.HP += 5;
                            op2.d_long++;
                            op2.d_short++;
                        case 5:
                            op2.HP += 5;
                            op2.d_long++;
                            op2.d_short++;
                            op2.PVP++;
                        case 4:
                            op2.d_long++;
                            op2.d_short++;
                            op2.HP += 5;
                            op2.AC--;
                        case 3:
                            op2.HP += 30;
                            op2.AC -= 3;
                    }
                }
            } else if (name.contains("Em")) {
                switch (enchant) {
                    case 8:
                        op2.HP += 5;
                        op2.d_long++;
                        op2.d_short++;
                        op2.PVP++;
                        op2.HIT_SHORT++;
                        op2.HIT_LONG++;
                    case 7:
                        op2.HP += 5;
                        op2.d_long++;
                        op2.d_short++;
                        op2.PVP++;
                        op2.HIT_SHORT++;
                        op2.HIT_LONG++;
                    case 6:
                        op2.HP += 5;
                        op2.d_long++;
                        op2.d_short++;
                        op2.HIT_SHORT++;
                        op2.HIT_LONG++;
                    case 5:
                        op2.HP += 5;
                        op2.d_long++;
                        op2.d_short++;
                        op2.PVP++;
                        op2.HIT_SHORT++;
                        op2.HIT_LONG++;
                    case 4:
                        op2.HP += 5;
                        op2.AC--;
                    case 3:
                        op2.HP += 5;
                        op2.AC--;
                    case 2:
                        op2.AC--;
                    case 1:
                        op2.AC--;
                }
            } else if (name.contains("mb")) {
                switch (enchant) {
                    case 8:
                        op2.HP += 5;
                        op2.PVP++;
                        op2.SP++;
                    case 7:
                        op2.HP += 5;
                        op2.PVP++;
                    case 6:
                        op2.HP += 5;
                        op2.SP++;
                    case 5:
                        op2.HP += 5;
                        op2.AC--;
                    case 4:
                        op2.HP += 5;
                        op2.AC--;
                    case 3:
                        op2.HP += 5;
                        op2.AC--;
                    case 2:
                        op2.AC--;
                    case 1:
                        op2.HP += 5;
                }
            } else {
                switch (enchant) {
                    case 8:
                        op2.HP += 5;
                        op2.d_long++;
                        op2.d_short++;
                        op2.PVP++;
                        op2.HIT_SHORT++;
                        op2.HIT_LONG++;
                    case 7:
                        op2.HP += 5;
                        op2.d_long++;
                        op2.d_short++;
                        op2.PVP++;
                        op2.HIT_SHORT++;
                        op2.HIT_LONG++;
                    case 6:
                        op2.HP += 5;
                        op2.d_long++;
                        op2.d_short++;
                        op2.HIT_SHORT++;
                        op2.HIT_LONG++;
                    case 5:
                        op2.HP += 5;
                        op2.d_long++;
                        op2.d_short++;
                        op2.PVP++;
                        op2.HIT_SHORT++;
                        op2.HIT_LONG++;
                    case 4:
                        op2.HP += 5;
                        op2.AC--;
                    case 3:
                        op2.HP += 5;
                        op2.AC--;
                    case 2:
                        op2.HP += 5;
                        op2.AC--;
                    case 1:
                        op2.HP += 15;
                }
            }
        }
        

        if (name.equals("íÌ}g")) {
            if (enchant >= 5) {
                op2.AC = -2;
            }
            if (enchant >= 6) {
                op2.MR = 20;
            }
            if (enchant >= 7) {
                op2.HP = 40;
                op2.MP = 40;
            }
            if (enchant >= 8) {
                op2.DR = 1;
            }
            if (enchant >= 9) {
                op2.ST[STR] = 1;
            }
        }
        if (name.equals("íÌP[v")) {
            if (enchant >= 5) {
                op2.AC = -2;
            }
            if (enchant >= 6) {
                op2.MR = 20;
            }
            if (enchant >= 7) {
                op2.d_long = 1;
            }
            if (enchant >= 8) {
                op2.DR = 1;
            }
            if (enchant >= 9) {
                op2.ST[DEX] = 1;
            }
        }
        if (name.equals("íÌN[N")) {
            if (enchant >= 5) {
                op2.AC = -2;
            }
            if (enchant >= 6) {
                op2.MR = 20;
            }
            if (enchant >= 7) {
                op2.MPR = 4;
            }
            if (enchant >= 8) {
                op2.DR = 1;
            }
            if (enchant >= 9) {
                op2.ST[INT] = 1;
            }
        }

        if (name.equals("b`[u(KR)")) {
            if (enchant >= 3) {
                op2.SP = enchant - 2;
            }
        }

        if (name.equals("®{ÌO[u(KR)")) {
            if (enchant >= 5) {
                op2.HIT_SHORT = enchant - 4;
            }
        }

        if (name.equals("K^ÌT[Nbg")) {
            if (enchant > 0) {
                op2.SP = 1;
            }
        }

        if (name.equals("å@g¢ÌXq")) {
            op2.MP = 10 * enchant;
        }
        
        
        if (name.equals("VZVXQ[g")) {
            op2.HP = 5 * enchant;
        }

        if (name.equals("íÌO[u")) {
            if (enchant >= 5) {
                op2.HP = 30;
            }
            if (enchant >= 6) {
                op2.MR = 2;
            }
            if (enchant >= 7) {
                op2.ST[STR] = 1;
            }
            if (enchant >= 8) {
                op2.MP = 20;
            }
            if (enchant >= 9) {
                op2.d_short = 1;
            }
        }
        if (name.equals("íÌuCT[")) {
            if (enchant >= 5) {
                op2.HP = 30;
            }
            if (enchant >= 6) {
                op2.MPR = 1;
            }
            if (enchant >= 7) {
                op2.ST[DEX] = 1;
            }
            if (enchant >= 8) {
                op2.MP = 20;
            }
            if (enchant >= 9) {
                op2.d_long = 1;
            }
        }
        if (name.equals("íÌ~g")) {
            if (enchant >= 5) {
                op2.HP = 30;
            }
            if (enchant >= 6) {
                op2.MPR = 1;
            }
            if (enchant >= 7) {
                op2.ST[WIS] = 1;
            }
            if (enchant >= 8) {
                op2.MP = 20;
            }
            if (enchant >= 9) {
                op2.SP = 1;
            }
        }

        if (name.equals("íÌO[u")) {
            if (enchant >= 5) {
                op2.HP = 25;
            }
            if (enchant >= 6) {
                op2.MP = 20;
            }
            if (enchant >= 7) {
                op2.AC = -2;
            }
            if (enchant >= 8) {
                op2.ST[WIS] = 1;
            }
            if (enchant >= 9) {
                op2.ST[STR] = 1;
            }
        }
        if (name.equals("íÌu[c")) {
            if (enchant >= 5) {
                op2.HP = 25;
            }
            if (enchant >= 6) {
                op2.MP = 20;
            }
            if (enchant >= 7) {
                op2.AC = -2;
            }
            if (enchant >= 8) {
                op2.ST[WIS] = 1;
            }
            if (enchant >= 9) {
                op2.ST[DEX] = 1;
            }
        }
        if (name.equals("íÌoXL")) {
            if (enchant >= 5) {
                op2.HP = 25;
            }
            if (enchant >= 6) {
                op2.MP = 20;
            }
            if (enchant >= 7) {
                op2.AC = -2;
            }
            if (enchant >= 8) {
                op2.ST[WIS] = 1;
            }
            if (enchant >= 9) {
                op2.ST[INT] = 1;
            }
        }

        if (type.equals("O") || type.equals("A~bg")
                || type.equals("CAO") || type.equals("xg")) {

            if (tokusei.equals("îM")) {
                switch (enchant) {
                    case 1:
                        op2.HP = 5;
                        break;
                    case 2:
                        op2.HP = 10;
                        break;
                    case 3:
                        op2.HP = 20;
                        break;
                    case 4:
                        op2.HP = 30;
                        break;
                    case 5:
                        op2.HP = 40;
                        op2.d_long = 1;
                        op2.d_short = 1;
                        break;
                    case 6:
                        op2.HP = 40;
                        op2.d_long = 2;
                        op2.d_short = 2;
                        break;
                    case 7:
                        op2.HP = 50;
                        op2.d_long = 3;
                        op2.d_short = 3;
                        op2.SP = 1;
                        break;
                    case 8:
                        op2.HP = 50;
                        op2.d_long = 4;
                        op2.d_short = 4;
                        op2.SP = 2;
                        break;
                }
            }

            if (tokusei.equals("ª«")) {
                switch (enchant) {
                    case 1:
                        op2.HP = 5;
                        break;
                    case 2:
                        op2.HP = 10;
                        break;
                    case 3:
                        op2.HP = 20;
                        break;
                    case 4:
                        op2.HP = 30;
                        break;
                    case 5:
                        op2.HP = 40;
                        op2.effect = "|[VñÊ +2% +0,";
                        break;
                    case 6:
                        op2.HP = 40;
                        op2.effect = "|[VñÊ +4% +2,";
                        break;
                    case 7:
                        op2.HP = 50;
                        op2.effect = "|[VñÊ +6% +4,";
                        break;
                    case 8:
                        op2.HP = 50;
                        op2.effect = "|[VñÊ +8% +6,";
                        break;
                }

            }

            if (tokusei.equals("Ón")) {
                switch (enchant) {
                    case 1:
                        op2.MP = 5;
                        break;
                    case 2:
                        op2.MP = 10;
                        break;
                    case 3:
                        op2.MP = 20;
                        break;
                    case 4:
                        op2.MP = 30;
                        break;
                    case 5:
                        op2.MP = 40;
                        op2.DR = 1;
                        break;
                    case 6:
                        op2.MP = 40;
                        op2.DR = 2;
                        break;
                    case 7:
                        op2.MP = 50;
                        op2.DR = 3;
                        break;
                    case 8:
                        op2.MP = 50;
                        op2.DR = 4;
                        break;
                }
            }

            if (grade.equals("Á")) {
                switch (enchant) {
                    case 1:
                        op2.HP = 15;
                        break;
                    case 2:
                        op2.HP = 20;
                        op2.AC = -1;
                        break;
                    case 3:
                        op2.HP = 25;
                        op2.AC = -2;
                        break;
                    case 4:
                        op2.HP = 30;
                        op2.AC = -3;
                        break;
                    case 5:
                        op2.HP = 35;
                        op2.AC = -3;
                        op2.d_short = 1;
                        op2.d_long = 1;
                        break;
                    case 6:
                        op2.HP = 40;
                        op2.AC = -3;
                        op2.d_short = 2;
                        op2.d_long = 2;
                        break;
                    case 7:
                        op2.HP = 45;
                        op2.AC = -3;
                        op2.d_short = 3;
                        op2.d_long = 3;
                        break;
                    case 8:
                        op2.HP = 50;
                        op2.AC = -3;
                        op2.d_short = 4;
                        op2.d_long = 4;
                        break;
                }
            }
            if (name.equals("[eBX bh CAO")) {
                switch (enchant) {
                    case 0:
                        op.HP = 10;
                        break;
                    case 1:
                        op.HP = 30;
                        break;
                    case 2:
                        op.HP = 40;
                        break;
                    case 3:
                        op.HP = 50;
                        op.DR = 1;
                        break;
                    case 4:
                        op.HP = 60;
                        op.DR = 1;
                        break;
                    case 5:
                        op.HP = 70;
                        op.DR = 2;
                        op.effect = "_[Wy¸+20 2%,";
                        break;
                    case 6:
                        op.HP = 80;
                        op.DR = 3;
                        op.effect = "_[Wy¸+20 3%,";
                        break;
                    case 7:
                        op.HP = 90;
                        op.DR = 4;
                        op.effect = "_[Wy¸+20 4%,";
                        break;
                    case 8:
                        op.HP = 100;
                        op.DR = 5;
                        op.effect = "_[Wy¸+20 5%,";
                        break;
                }
            }
            if (name.equals("[eBX p[v CAO")) {
                switch (enchant) {
                    case 0:
                        op.MP = 5;
                        op.MR = 2;
                        break;
                    case 1:
                        op.MP = 15;
                        op.MR = 5;
                        break;
                    case 2:
                        op.MP = 20;
                        op.MR = 6;
                        break;
                    case 3:
                        op.MP = 35;
                        op.MR = 7;
                        op.SP = 1;
                        break;
                    case 4:
                        op.MP = 40;
                        op.MR = 8;
                        op.SP = 1;
                        break;
                    case 5:
                        op.MP = 55;
                        op.MR = 9;
                        op.SP = 2;
                        break;
                    case 6:
                        op.MP = 60;
                        op.MR = 10;
                        op.SP = 2;
                        break;
                    case 7:
                        op.MP = 75;
                        op.MR = 12;
                        op.SP = 3;
                        break;
                    case 8:
                        op.MP = 100;
                        op.MR = 15;
                        op.SP = 3;
                        break;
                }
            }
            if (name.equals("[eBX u[ CAO")) {
                switch (enchant) {
                    case 0:
                        op.effect = "|[VñÊ +2% +2,";
                        break;
                    case 1:
                        op.effect = "|[VñÊ +6% +6,";
                        break;
                    case 2:
                        op.effect = "|[VñÊ +8% +8,";
                        break;
                    case 3:
                        op.effect = "|[VñÊ +10% +10,";
                        break;
                    case 4:
                        op.effect = "|[VñÊ +12% +12,";
                        break;
                    case 5:
                        op.AC = -1;
                        op.effect = "|[VñÊ +14% +14,";
                        break;
                    case 6:
                        op.AC = -2;
                        op.effect = "|[VñÊ +16% +16,";
                        break;
                    case 7:
                        op.AC = -2;
                        op.effect = "|[VñÊ +18% +18,";
                        break;
                    case 8:
                        op.AC = -3;
                        op.effect = "|[VñÊ +20% +20,";
                        break;
                }
            }
        } else {
            op2.AC += -enchant;
            op2.MR += enchant * mr_enchant;
        }
    }
}
