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
                if (line.startsWith("���S=")) {
                    safety = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("�������E=")) {
                    max_enchant = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("type=")) {
                    type = line.split("=")[1];
                }
                if (line.startsWith("�ގ�=")) {
                    material = line.split("=")[1];
                }
                if (line.startsWith("�O���[�h=")) {
                    grade = line.split("=")[1];
                }
                if (line.startsWith("MR����=")) {
                    mr_enchant = Integer.parseInt(line.split("=")[1]);
                }
                if (line.startsWith("��͋���=")) {
                    element_enchant = Boolean.parseBoolean(line.split("=")[1]);
                }
                if (line.startsWith("����=")) {
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
            text += " HP���R��+" + (op.HPR + op2.HPR);
        }
        if (op.HPR + op2.HPR < 0) {
            text += " HP���R��" + (op.HPR + op2.HPR);
        }
        if (op.MPR + op2.MPR > 0) {
            text += " MP���R��+" + (op.MPR + op2.MPR);
        }
        if (op.MPR + op2.MPR < 0) {
            text += " MP���R��" + (op.MPR + op2.MPR);
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
            text += " �ǉ��Ō�+" + (op.d_short + op2.d_short);
        }
        if (op.HIT_SHORT + op2.HIT_SHORT > 0) {
            text += " �U������+" + (op.HIT_SHORT + op2.HIT_SHORT);
        }
        if (op.HIT_LONG + op2.HIT_LONG > 0) {
            text += " �|������+" + (op.HIT_LONG + op2.HIT_LONG);
        }
        if (op.d_long + op2.d_long > 0) {
            text += " �������_���[�W+" + (op.d_long + op2.d_long);
        }
        if (op.SP + op2.SP > 0) {
            text += " ����+" + (op.SP + op2.SP);
        }
        if (op.SP < 0) {
            text += " ����" + op.SP;
        }
        if (op.element_resist[FIRE] > 0) {
            text += " �΂̑���" + op.element_resist[FIRE];
        }
        if (op.element_resist[WATER] > 0) {
            text += " ���̑���" + op.element_resist[WATER];
        }
        if (op.element_resist[WIND] > 0) {
            text += " ���̑���" + op.element_resist[WIND];
        }
        if (op.element_resist[EARTH] > 0) {
            text += " �n�̑���" + op.element_resist[EARTH];
        }
        if (op.MR > 0) {
            text += " ���@�h��+" + (op.MR + op2.MR);
        }
        if (mr_enchant > 0) {
            text += " (��������MR+" + mr_enchant + ")";
        }
        if (op.ailment[STUN] > 0) {
            text += " �X�^���ϐ�+" + op.ailment[STUN];
        }
        if (op.ailment[HOLD] > 0) {
            text += " �z�[���h�ϐ�+" + op.ailment[HOLD];
        }
        if (op.ailment[SLEEP] > 0) {
            text += " �����ϐ�+" + op.ailment[SLEEP];
        }
        if (op.ailment[FREEZE] > 0) {
            text += " �����ϐ�+" + op.ailment[FREEZE];
        }
        if (op.ailment[STONE] > 0) {
            text += " �Ή��ϐ�+" + op.ailment[STONE];
        }
        if (op.ailment[DARKNESS] > 0) {
            text += " �Èőϐ�+" + op.ailment[DARKNESS];
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

        if (name.equals("����̃}���g")) {
            op2 = new Buff();
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
        if (name.equals("����̃P�[�v")) {
            op2 = new Buff();
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
        if (name.equals("����̃N���[�N")) {
            op2 = new Buff();
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

        if (name.equals("���b�`���[�u(KR)")) {
            op2 = new Buff();
            if (enchant >= 3) {
                op2.SP = enchant - 2;
            }
        }

        if (name.equals("���{�̃O���[�u(KR)")) {
            op2 = new Buff();
            if (enchant >= 5) {
                op2.HIT_SHORT = enchant - 4;
            }
        }

        if (name.equals("�K�^�̃T�[�N���b�g")) {
            op2 = new Buff();
            if (enchant > 0) {
                op2.SP = 1;
            }
        }

        if (name.equals("�喂�@�g���̖X�q")) {
            op2.MP = 10 * enchant;
        }

        if (name.equals("����̃O���[�u")) {
            op2 = new Buff();
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
        if (name.equals("����̃u���C�T�[")) {
            op2 = new Buff();
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
        if (name.equals("����̃~�g��")) {
            op2 = new Buff();
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

        if (name.equals("����̃O���[�u")) {
            op2 = new Buff();
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
        if (name.equals("����̃u�[�c")) {
            op2 = new Buff();
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
        if (name.equals("����̃o�X�L��")) {
            op2 = new Buff();
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

        if (type.equals("�����O") || type.equals("�A�~�����b�g")
                || type.equals("�C�A�����O") || type.equals("�x���g")) {
            op2 = new Buff();

            if (tokusei.equals("��M")) {
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
                        break;
                    case 8:
                        op2.HP = 50;
                        op2.d_long = 4;
                        op2.d_short = 4;
                        break;
                }
            }

            if (tokusei.equals("����")) {
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
                        op2.effect = "�|�[�V�����񕜗� +2%,";
                        break;
                    case 6:
                        op2.HP = 40;
                        op2.effect = "�|�[�V�����񕜗� +4% +2,";
                        break;
                    case 7:
                        op2.HP = 50;
                        op2.effect = "�|�[�V�����񕜗� +6% +4,";
                        break;
                    case 8:
                        op2.HP = 50;
                        op2.effect = "�|�[�V�����񕜗� +8% +6,";
                        break;
                }

            }

            if (tokusei.equals("�Ӓn")) {
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

            if (grade.equals("����")) {
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
            if (name.equals("���[���e�B�X ���b�h �C�A�����O")) {
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
                        op.effect = "�_���[�W�y��+20 2%,";
                        break;
                    case 6:
                        op.HP = 80;
                        op.DR = 3;
                        op.effect = "�_���[�W�y��+20 3%,";
                        break;
                    case 7:
                        op.HP = 90;
                        op.DR = 4;
                        op.effect = "�_���[�W�y��+20 4%,";
                        break;
                    case 8:
                        op.HP = 100;
                        op.DR = 5;
                        op.effect = "�_���[�W�y��+20 5%,";
                        break;
                }
            }
            if (name.equals("���[���e�B�X �p�[�v�� �C�A�����O")) {
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
            if (name.equals("���[���e�B�X �u���[ �C�A�����O")) {
                switch (enchant) {
                    case 0:
                        op.effect = "�|�[�V�����񕜗� +2% +2,";
                        break;
                    case 1:
                        op.effect = "�|�[�V�����񕜗� +6% +6,";
                        break;
                    case 2:
                        op.effect = "�|�[�V�����񕜗� +8% +8,";
                        break;
                    case 3:
                        op.effect = "�|�[�V�����񕜗� +10% +10,";
                        break;
                    case 4:
                        op.effect = "�|�[�V�����񕜗� +12% +12,";
                        break;
                    case 5:
                        op.AC = -1;
                        op.effect = "�|�[�V�����񕜗� +14% +14,";
                        break;
                    case 6:
                        op.AC = -2;
                        op.effect = "�|�[�V�����񕜗� +16% +16,";
                        break;
                    case 7:
                        op.AC = -2;
                        op.effect = "�|�[�V�����񕜗� +18% +18,";
                        break;
                    case 8:
                        op.AC = -3;
                        op.effect = "�|�[�V�����񕜗� +20% +20,";
                        break;
                }
            }
        } else {
            op2.AC += -enchant;
            op2.MR += enchant * mr_enchant;
        }
    }
}