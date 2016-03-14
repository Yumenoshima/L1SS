/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lss;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import static lss.Common.eq_list;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 *
 * @author user
 */
public class UI extends JFrame implements Common, ActionListener, ChangeListener {

    Calculator calc = new Calculator(this);

    String version = "";
    JTabbedPane tabpane;
    JPanel panels[] = new JPanel[4];

    //UIパーツ
    //共通
    JLabel[] lab_st = new JLabel[st_list.length];
    JLabel[] lab_st_sum = new JLabel[st_list.length];
    JLabel[] lab_st_base = new JLabel[st_list.length];
    JLabel[] lab_st_lev = new JLabel[st_list.length];
    JLabel[] lab_st_add = new JLabel[st_list.length];
    JLabel lab_rem;

    JButton[] bt_down = new JButton[st_list.length];
    JButton[] bt_up = new JButton[st_list.length];

    JComboBox cb_lev;
    JComboBox cb_cls;

    JButton bt_save;
    JButton bt_load;

    JLabel lab_ac;
    JLabel lab_dg;
    JLabel lab_er;
    JLabel lab_dr;
    JLabel lab_mr;

    JLabel lab_pot1;
    JLabel lab_pot2;

    JLabel lab_dmg_short, lab_dmg_long, lab_dmg_mag;
    JLabel lab_hit_short, lab_hit_long, lab_hit_mag;
    JLabel lab_ac_short, lab_ac_long;
    JLabel lab_dmg_normal;
    JLabel lab_dmg_cursed;
    JLabel lab_dmg_undead;
    JLabel lab_mag_info1;
    JLabel lab_mag_info2;
    JLabel lab_hit_rate;

    JLabel lab_hp;
    JLabel lab_mp;

    //共通パーツ入れ
    ArrayList<JComponent> commons = new ArrayList<>();

    //パネル１
    JComboBox cb_eq_ch;
    JButton bt_copy;
    JButton bt_paste;
    JButton bt_reset;

    WideComboBox[] cb_eq = new WideComboBox[eq_list.length];
    JComboBox[] cb_eq_en = new JComboBox[eq_list.length];
    JComboBox cb_elem_1;
    JComboBox cb_elem_2;
    JComboBox cb_ts_elem;
    JToggleButton tb_ts_sp;
    JToggleButton tb_blessed1;
    JToggleButton tb_blessed2;
    JComboBox cb_arrow;

    WideComboBox cb_pattern_l;
    WideComboBox cb_pattern_r;
    WideComboBox cb_pattern_c;
    WideComboBox cb_pattern_l2;
    WideComboBox cb_pattern_r2;

    JTextField tf_weight;
    JTextField tf_weight2;
//    JCheckBox cb_weight_auto;
    JComboBox cb_weight;
    JTextField tf_speed;
    JTextField tf_acc;
    JTextField tf_magic_speed_main;
    JTextField tf_magic_speed_sub;
    JCheckBox cb_speed_auto;

    JComboBox cb_morph_type;
    JComboBox cb_morph_level;

    JTextField tf_buki_sp_rate;
    JLabel lab_sp_sub;
    JTextField tf_mag_rate;
    JTextField tf_mag_delay;
    JTextField tf_mag_power;
    JLabel lab_sp_rate;
    JLabel lab_mag_rate;
    JLabel lab_mag_delay;
    JLabel lab_mag_power;
    JCheckBox cb_mag_auto;
    JComboBox cb_magic;

    JLabel lab_hpr;
    JLabel lab_mpr;
    JLabel[] lab_elem = new JLabel[elem_list.length];
    JLabel[] lab_ailment = new JLabel[ailment_list.length];

    JLabel lab_pot;

    //パネル２
    JLabel[][] pure_status_bonus = new JLabel[2][25];

    JComboBox[] cb_elixir = new JComboBox[5];
    JComboBox[] cb_elixir_level = new JComboBox[5];
    LEV lev = new LEV();

    //パネル３
    JCheckBox[] cb_buff = new JCheckBox[78];
    JComboBox[] cb_buff_group = new JComboBox[78];

    //パネル４
    JComboBox cb_npc_level;
    JSlider[] s_target_res = new JSlider[elem_list.length];
    JLabel[] lab_target_resist = new JLabel[elem_list.length];
    JComboBox cb_target_dr;
    JSlider s_target_mr;
    JLabel lab_target_mr;
    JComboBox cb_target_ac;
    JComboBox cb_mode_pc;
    JComboBox cb_target_dg;
    JCheckBox cb_sonsyou;
    JCheckBox cb_hittyuu;
//    JCheckBox cb_kago;
//    JCheckBox cb_i2h;
//    JCheckBox cb_ab;
//    JCheckBox cb_cb;
//    JCheckBox cb_tate;
    JComboBox cb_res;
    JTextField tf_res_name;
    JButton bt_save_res;
    JButton bt_load_res;
    JButton bt_ow_res;
    JButton bt_del_res;
    JLabel lab_default;

    JTextField tf_e_hp;
    JTextField tf_e_hpr;
    JComboBox cb_e_type;
    JComboBox cb_e_size;
    JLabel lab_time;

    ZipFile eq_files;
    ArrayList<ZipEntry>[] eq_entrys = new ArrayList[eq_list.length];

    {
        for (int i = 0; i < eq_entrys.length; i++) {
            eq_entrys[i] = new ArrayList<>();
        }
    }

    ArrayList<ZipEntry> arrow_entrys = new ArrayList();
    ArrayList<ZipEntry> sting_entrys = new ArrayList();

    void init() {

        boolean error = false;

        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream("./version.txt")));
            version = reader.readLine();
        } catch (IOException ex) {
            error = true;
        }

        setTitle("Lineage Status Simulator ver " + version);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setResizable(false);

        tabpane = new JTabbedPane();

        panels[0] = new JPanel();
        panels[1] = new JPanel();
        panels[2] = new JPanel();
        panels[3] = new JPanel();

        panels[0].setLayout(null);
        panels[1].setLayout(null);
        panels[2].setLayout(null);
        panels[3].setLayout(null);

        tabpane.add("装備/ステータス", panels[0]);
        tabpane.add("レベル/エリクサー", panels[1]);
        tabpane.add("エンチャント", panels[2]);
        tabpane.add("耐性設定", panels[3]);

        add(tabpane);

        //----------
        //共通
        //----------
        JLabel lab_tmp;

        bt_save = new JButton("保存");
        bt_save.setBounds(550, 0, 100, 25);
        panels[0].add(bt_save);
        commons.add(bt_save);
        bt_save.addActionListener(this);
        bt_save.setActionCommand("save");

        bt_load = new JButton("読込");
        bt_load.setBounds(650, 0, 100, 25);
        panels[0].add(bt_load);
        commons.add(bt_load);
        bt_load.addActionListener(this);
        bt_load.setActionCommand("load");

        cb_cls = new WideComboBox(class_list2);
        cb_cls.setBounds(0, 0, 100, 25);
        cb_cls.addActionListener(this);
        cb_cls.setActionCommand("reset");
        panels[0].add(cb_cls);
        commons.add(cb_cls);

        lab_tmp = new JLabel("レベル");
        lab_tmp.setBounds(120, 0, 30, 25);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);

        lab_tmp = new JLabel("-");
        lab_tmp.setBounds(55, 30, 20, 20);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);

        lab_tmp = new JLabel("+");
        lab_tmp.setBounds(75, 30, 20, 20);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);

        String lev_list[] = new String[88];
        for (int i = 0; i < lev_list.length; i++) {
            lev_list[i] = Integer.toString(i + 1);
        }
        cb_lev = new WideComboBox(lev_list);
        cb_lev.addActionListener(this);
        cb_lev.setBounds(160, 0, 50, 25);
        panels[0].add(cb_lev);
        commons.add(cb_lev);

        for (int i = 0; i < st_list.length; i++) {

            lab_st[i] = new JLabel(st_list[i]);
            lab_st[i].setBounds(0, 50 + i * 20, 30, 20);
            panels[0].add(lab_st[i]);
            commons.add(lab_st[i]);

            bt_down[i] = new JButton();
            bt_down[i].setBounds(50, 50 + i * 20, 20, 20);
            bt_down[i].setActionCommand(st_list[i] + "/down");
            bt_down[i].addActionListener(this);
            panels[0].add(bt_down[i]);
            commons.add(bt_down[i]);

            bt_up[i] = new JButton();
            bt_up[i].setBounds(70, 50 + i * 20, 20, 20);
            bt_up[i].setActionCommand(st_list[i] + "/up");
            bt_up[i].addActionListener(this);
            panels[0].add(bt_up[i]);
            commons.add(bt_up[i]);

            lab_st_sum[i] = new JLabel("0", SwingConstants.CENTER);
            lab_st_sum[i].setHorizontalTextPosition(SwingConstants.CENTER);
            lab_st_sum[i].setBounds(30, 50 + 20 * i, 20, 20);
            lab_st_base[i] = new JLabel("0", SwingConstants.CENTER);
            lab_st_base[i].setHorizontalTextPosition(SwingConstants.CENTER);
            lab_st_base[i].setBounds(100, 50 + 20 * i, 20, 20);
            lab_st_add[i] = new JLabel("0", SwingConstants.CENTER);
            lab_st_add[i].setHorizontalTextPosition(SwingConstants.CENTER);
            lab_st_add[i].setBounds(160, 50 + 20 * i, 20, 20);
            lab_st_lev[i] = new JLabel("0", SwingConstants.CENTER);
            lab_st_lev[i].setHorizontalTextPosition(SwingConstants.CENTER);
            lab_st_lev[i].setBounds(130, 50 + 20 * i, 20, 20);

            panels[0].add(lab_st_sum[i]);
            panels[0].add(lab_st_base[i]);
            panels[0].add(lab_st_add[i]);
            panels[0].add(lab_st_lev[i]);
            commons.add(lab_st_sum[i]);
            commons.add(lab_st_base[i]);
            commons.add(lab_st_add[i]);
            commons.add(lab_st_lev[i]);
        }

        lab_tmp = new JLabel("REM");
        lab_tmp.setBounds(0, 50 + 120, 30, 20);
        panels[0].add(lab_tmp);
        lab_tmp = new JLabel("REM");
        lab_tmp.setBounds(0, 50 + 120, 30, 20);
        panels[1].add(lab_tmp);

        lab_rem = new JLabel("", JLabel.CENTER);
        lab_rem.setBounds(30, 50 + 120, 20, 20);
        panels[0].add(lab_rem);

        lab_tmp = new JLabel("初期", JLabel.CENTER);
        lab_tmp.setBounds(100, 25, 30, 25);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);
        lab_tmp = new JLabel("LV", JLabel.CENTER);
        lab_tmp.setBounds(130, 25, 30, 25);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);
        lab_tmp = new JLabel("追加", JLabel.CENTER);
        lab_tmp.setBounds(160, 25, 30, 25);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);
        lab_tmp = new JLabel("合計", JLabel.CENTER);
        lab_tmp.setBounds(20, 25, 30, 25);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);

        lab_tmp = new JLabel("HP");
        lab_tmp.setBounds(200 + 25, 45, 200, 20);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);
        lab_tmp = new JLabel("MP");
        lab_tmp.setBounds(200 + 60 + 25, 45, 200, 20);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);
        lab_hp = new JLabel();
        lab_hp.setBounds(230 + 25, 45, 70, 20);
        lab_mp = new JLabel();
        lab_mp.setBounds(290 + 25, 45, 70, 20);

        lab_tmp = new JLabel("AC");
        lab_tmp.setBounds(200 + 25, 45 + 20, 200, 20);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);
        lab_tmp = new JLabel("MR");
        lab_tmp.setBounds(260 + 25, 45 + 20, 200, 20);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);
        lab_tmp = new JLabel("DR");
        lab_tmp.setBounds(320 + 25, 45 + 20, 200, 20);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);
        lab_ac = new JLabel();
        lab_mr = new JLabel();
        lab_dr = new JLabel();
        lab_ac.setBounds(200 + 30 + 25, 45 + 20, 200, 20);
        lab_mr.setBounds(200 + 90 + 25, 45 + 20, 200, 20);
        lab_dr.setBounds(200 + 150 + 25, 45 + 20, 200, 20);
        panels[0].add(lab_ac);
        commons.add(lab_ac);
        panels[0].add(lab_mr);
        commons.add(lab_mr);
        panels[0].add(lab_dr);
        commons.add(lab_dr);

        lab_tmp = new JLabel("DG");
        lab_tmp.setBounds(200 + 25, 45 + 40, 200, 20);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);
        lab_tmp = new JLabel("ER");
        lab_tmp.setBounds(260 + 25, 45 + 40, 200, 20);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);
        lab_dg = new JLabel();
        lab_er = new JLabel();
        lab_dg.setBounds(200 + 30 + 25, 45 + 40, 200, 20);
        lab_er.setBounds(200 + 90 + 25, 45 + 40, 200, 20);
        panels[0].add(lab_dg);
        commons.add(lab_dg);
        panels[0].add(lab_er);
        commons.add(lab_er);

        lab_tmp = new JLabel("HPR");
        lab_tmp.setBounds(200 + 25, 45 + 60, 200, 20);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);
        lab_tmp = new JLabel("MPR");
        lab_tmp.setBounds(200 + 25, 45 + 80, 200, 20);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);
        panels[0].add(lab_hp);
        panels[0].add(lab_mp);
        commons.add(lab_hp);
        commons.add(lab_mp);

        lab_hpr = new JLabel();
        lab_mpr = new JLabel();
        lab_hpr.setBounds(200 + 40 + 25, 45 + 60, 200, 20);
        lab_mpr.setBounds(200 + 40 + 25, 45 + 80, 200, 20);
        panels[0].add(lab_hpr);
        panels[0].add(lab_mpr);
        commons.add(lab_hpr);
        commons.add(lab_mpr);

        lab_pot = new JLabel("ポーション回復量");
        lab_pot.setBounds(200 + 25, 45 + 100, 200, 20);
        panels[0].add(lab_pot);
        commons.add(lab_pot);

        lab_pot1 = new JLabel();
        lab_pot1.setBounds(200 + 25 + 100, 45 + 100, 100, 20);
        panels[0].add(lab_pot1);
        commons.add(lab_pot1);

        lab_pot2 = new JLabel();
        lab_pot2.setBounds(200 + 25 + 130, 45 + 100, 100, 20);
        panels[0].add(lab_pot2);
        commons.add(lab_pot2);

        lab_dmg_short = new JLabel();
        lab_dmg_long = new JLabel();
        lab_dmg_mag = new JLabel();
        lab_hit_short = new JLabel();
        lab_hit_long = new JLabel();
        lab_hit_mag = new JLabel();
        lab_ac_short = new JLabel();
        lab_ac_long = new JLabel();
        lab_dmg_short.setBounds(420, 25 + 10, 150, 20);
        lab_dmg_long.setBounds(420, 25 + 25 + 10, 150, 20);
        lab_dmg_mag.setBounds(420, 25 + 50 + 10, 150, 20);
        lab_hit_short.setBounds(420 + 125, 25 + 10, 250, 20);
        lab_hit_long.setBounds(420 + 125, 25 + 25 + 10, 250, 20);
        lab_hit_mag.setBounds(420 + 125, 25 + 50 + 10, 150, 20);
        lab_ac_short.setBounds(420 + 125 + 100, 25 + 10, 150, 20);
        lab_ac_long.setBounds(420 + 125 + 100, 25 + 25 + 10, 150, 20);
        panels[0].add(lab_dmg_short);
        panels[0].add(lab_dmg_long);
        panels[0].add(lab_dmg_mag);
        panels[0].add(lab_hit_short);
        panels[0].add(lab_hit_long);
        panels[0].add(lab_hit_mag);
        panels[0].add(lab_ac_short);
        panels[0].add(lab_ac_long);
        commons.add(lab_dmg_short);
        commons.add(lab_dmg_long);
        commons.add(lab_dmg_mag);
        commons.add(lab_hit_short);
        commons.add(lab_hit_long);
        commons.add(lab_hit_mag);
        commons.add(lab_ac_long);
        commons.add(lab_ac_short);

        // 分間ダメージ
        lab_tmp = new JLabel("対通常");
        lab_tmp.setBounds(420, 50 + 50 + 10, 50, 25);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);
        lab_tmp = new JLabel("対悪魔");
        lab_tmp.setBounds(420, 50 + 50 + 25 + 10, 50, 25);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);
        lab_tmp = new JLabel("対不死");
        lab_tmp.setBounds(420, 50 + 50 + 50 + 10, 50, 25);
        panels[0].add(lab_tmp);
        commons.add(lab_tmp);

        //魔法・命中率
        lab_hit_rate = new JLabel();
        lab_mag_info1 = new JLabel();
        lab_mag_info2 = new JLabel();
        lab_hit_rate.setBounds(420 + 200, 50 + 50 + 10, 200, 25);
        lab_mag_info1.setBounds(420 + 200, 50 + 75 + 10, 300, 25);
        lab_mag_info2.setBounds(420 + 200, 50 + 100 + 10, 300, 25);
        panels[0].add(lab_hit_rate);
        panels[0].add(lab_mag_info1);
        panels[0].add(lab_mag_info2);
        commons.add(lab_hit_rate);
        commons.add(lab_mag_info1);
        commons.add(lab_mag_info2);

        lab_dmg_normal = new JLabel();
        lab_dmg_cursed = new JLabel();
        lab_dmg_undead = new JLabel();
        lab_dmg_normal.setBounds(420 + 50, 50 + 50 + 10, 400, 25);
        lab_dmg_cursed.setBounds(420 + 50, 50 + 75 + 10, 150, 25);
        lab_dmg_undead.setBounds(420 + 50, 50 + 100 + 10, 150, 25);
        panels[0].add(lab_dmg_normal);
        panels[0].add(lab_dmg_cursed);
        panels[0].add(lab_dmg_undead);
        commons.add(lab_dmg_normal);
        commons.add(lab_dmg_cursed);
        commons.add(lab_dmg_undead);

        //----------
        //パネル１
        //----------
        for (int i = 0, cnt = 1; i < eq_list.length; i++, cnt++) {

            cb_eq_en[i] = new JComboBox();
            cb_eq_en[i].setBounds(200 * (cnt % 2), 200 + 5 + (cnt - ((cnt + 1) / 2)) * 25, 50, 25);
            panels[0].add(cb_eq_en[i]);
            cb_eq_en[i].addActionListener(this);

            cb_eq[i] = new WideComboBox();
            cb_eq[i].setBounds(50 + 200 * (cnt % 2), 200 + 5 + (cnt - ((cnt + 1) / 2)) * 25, 150, 25);
            panels[0].add(cb_eq[i]);
            cb_eq[i].addActionListener(this);

            if (i >= 18) {
                cb_eq[i].setEnabled(false);
                cb_eq_en[i].setEnabled(false);
            }

            if (i == 4) {
                cnt++;
            }
            if (i == 2) {
                cnt++;
            }
            if (i == 0) {
                cnt++;
            }

        }
        String buki_elem_list[] = {"無属性", "火霊:1段", "火霊:2段", "火霊:3段", "火霊:4段",
            "火霊:5段", "水霊:1段", "水霊:2段", "水霊:3段", "水霊:4段", "水霊:5段", "風霊:1段",
            "風霊:2段", "風霊:3段", "風霊:4段", "風霊:5段", "地霊:1段", "地霊:2段", "地霊:3段",
            "地霊:4段", "地霊:5段"};

        cb_elem_1 = new JComboBox(buki_elem_list);
        cb_elem_1.setBounds(50, 200 + 5, 75, 25);
        cb_elem_1.addActionListener(this);
        panels[0].add(cb_elem_1);

        cb_elem_2 = new JComboBox(buki_elem_list);
        cb_elem_2.setBounds(50, 200 + 5 + 25, 75, 25);
        cb_elem_2.addActionListener(this);
        panels[0].add(cb_elem_2);

        String ts_ele_list[] = {"0段階", "1段階", "2段階", "3段階", "4段階", "5段階"};

        cb_ts_elem = new JComboBox(ts_ele_list);
        cb_ts_elem.setBounds(50, 275 + 5 + 25, 75, 25);
        cb_ts_elem.addActionListener(this);
        panels[0].add(cb_ts_elem);

        tb_ts_sp = new JToggleButton("特製");
        tb_ts_sp.setBounds(50 + 75, 275 + 5 + 25, 75, 25);
        panels[0].add(tb_ts_sp);
        tb_ts_sp.setEnabled(false);
        tb_ts_sp.addActionListener(this);

        tb_blessed1 = new JToggleButton("祝福");
        tb_blessed1.setBounds(125, 200 + 5, 75, 25);
        tb_blessed1.addActionListener(this);
        panels[0].add(tb_blessed1);

        tb_blessed2 = new JToggleButton("祝福");
        tb_blessed2.setBounds(125, 200 + 5 + 25, 75, 25);
        tb_blessed2.addActionListener(this);
        panels[0].add(tb_blessed2);

        cb_arrow = new JComboBox();
        cb_arrow.addActionListener(this);
        cb_arrow.setActionCommand("アロー");
        cb_arrow.setBounds(250, 225 + 5 + 25, 150, 25);
        panels[0].add(cb_arrow);

        tb_blessed2.setEnabled(false);
        cb_elem_2.setEnabled(false);
        cb_eq[1].setEnabled(false);
        cb_eq_en[1].setEnabled(false);

        String left_list[] = {"左腕", "腕力の紋様", "機敏の紋様", "体力の紋様", "知力の紋様", "精神の紋様",
            "魅力の紋様", "腕力の紋様II", "機敏の紋様II", "知力の紋様II", "剣士の紋様", "術士の紋様",
            "剣士の紋様II", "術士の紋様II", "弓士の紋様II"};
        String right_list[] = {"右腕", "生命の紋様", "魔法の紋様", "防御の紋様", "防御の紋様II", "耐火の紋様",
            "耐水の紋様", "耐風の紋様", "耐地の紋様", "属性抵抗の紋様", "生命の防御紋様", "魔力の防御紋様", "上級防御の紋様", "偉大なる者の遺物"};
        String center_list[] = {"背中", "祈りの紋様", "祈りの紋様II"};
        String left2_list[] = {"左手", "力のエリクサールーン", "機敏のエリクサールーン", "体力のエリクサールーン", "知力のエリクサールーン", "知恵のエリクサールーン", "力のエリクサールーン(Lv70)", "機敏のエリクサールーン(Lv70)", "体力のエリクサールーン(Lv70)", "知力のエリクサールーン(Lv70)", "知恵のエリクサールーン(Lv70)"};
        String right2_list[] = {"右手", "鎮守の護符(体力)", "鎮守の護符(魔力)", "戦士たちの護符", "射手たちの護符", "術士たちの護符"};
        cb_pattern_l = new WideComboBox(left_list);
        cb_pattern_r = new WideComboBox(right_list);
        cb_pattern_c = new WideComboBox(center_list);
        cb_pattern_l2 = new WideComboBox(left2_list);
        cb_pattern_r2 = new WideComboBox(right2_list);
        cb_pattern_l.setBounds(0, 400 + 110, 80, 25);
        cb_pattern_r.setBounds(80, 400 + 110, 80, 25);
        cb_pattern_c.setBounds(160, 400 + 110, 80, 25);
        cb_pattern_l2.setBounds(240, 400 + 110, 80, 25);
        cb_pattern_r2.setBounds(320, 400 + 110, 80, 25);
        cb_pattern_l.addActionListener(this);
        cb_pattern_r.addActionListener(this);
        cb_pattern_c.addActionListener(this);
        cb_pattern_l2.addActionListener(this);
        cb_pattern_r2.addActionListener(this);
        panels[0].add(cb_pattern_l);
        panels[0].add(cb_pattern_r);
        panels[0].add(cb_pattern_c);
        panels[0].add(cb_pattern_l2);
        panels[0].add(cb_pattern_r2);

        String ch_list[] = {"パターン1", "パターン2", "パターン3"};
        cb_eq_ch = new JComboBox(ch_list);
        cb_eq_ch.addActionListener(mem);
        cb_eq_ch.setActionCommand("ch");
        cb_eq_ch.setBounds(50, 175 + 5, 100, 25);
        panels[0].add(cb_eq_ch);

        bt_copy = new JButton("Copy");
        bt_copy.addActionListener(mem);
        bt_copy.setActionCommand("copy");
        bt_copy.setBounds(150, 175 + 5, 80, 25);
        panels[0].add(bt_copy);

        bt_paste = new JButton("Paste");
        bt_paste.addActionListener(mem);
        bt_paste.setActionCommand("paste");
        bt_paste.setBounds(230, 175 + 5, 80, 25);
        panels[0].add(bt_paste);

        bt_reset = new JButton("Reset");
        bt_reset.addActionListener(mem);
        bt_reset.setActionCommand("reset");
        bt_reset.setBounds(310, 175 + 5, 70, 25);
        panels[0].add(bt_reset);

        JLabel polymorph_label = new JLabel("変身");
        polymorph_label.setBounds(420, 175 + 5 + 25, 100, 25);
        panels[0].add(polymorph_label);
        cb_morph_type = new JComboBox();
        cb_morph_type.addItem("近/遠特化");
        cb_morph_type.addItem("魔法特化");
        cb_morph_type.setBounds(420 + 80, 175 + 5 + 25, 80, 25);
        cb_morph_type.addActionListener(this);
        panels[0].add(cb_morph_type);

        JLabel polymorph_level_label = new JLabel("変身レベル");
        polymorph_level_label.setBounds(420 + 200, 175 + 5 + 25, 100, 25);
        panels[0].add(polymorph_level_label);
        cb_morph_level = new JComboBox();
        cb_morph_level.addItem("自動");
        cb_morph_level.addItem("1");
        cb_morph_level.addItem("15");
        cb_morph_level.addItem("30");
        cb_morph_level.addItem("45");
        cb_morph_level.addItem("50");
        cb_morph_level.addItem("52");
        cb_morph_level.addItem("55");
        cb_morph_level.addItem("60");
        cb_morph_level.addItem("65");
        cb_morph_level.addItem("70");
        cb_morph_level.addItem("75");
        cb_morph_level.addItem("80");
        cb_morph_level.addItem("82");
        cb_morph_level.addItem("85");

        cb_morph_level.setBounds(420 + 280, 175 + 5 + 25, 80, 25);
        cb_morph_level.addActionListener(this);
        panels[0].add(cb_morph_level);

        lab_tmp = new JLabel("攻撃速度");
        lab_tmp.setBounds(420, 200 + 5 + 25, 200, 25);
        panels[0].add(lab_tmp);
        tf_speed = new JTextField();
        tf_speed.setBounds(500, 200 + 5 + 25, 80, 25);
        tf_speed.addActionListener(this);
        panels[0].add(tf_speed);

        lab_tmp = new JLabel("倍率");
        lab_tmp.setBounds(420, 225 + 5 + 25, 200, 25);
        panels[0].add(lab_tmp);
        tf_acc = new JTextField();
        tf_acc.setBounds(500, 225 + 5 + 25, 80, 25);
        tf_acc.addActionListener(this);
        panels[0].add(tf_acc);

        lab_tmp = new JLabel("攻魔");
        lab_tmp.setBounds(620, 200 + 5 + 25, 200, 25);
        panels[0].add(lab_tmp);
        tf_magic_speed_main = new JTextField();
        tf_magic_speed_main.setBounds(700, 200 + 5 + 25, 80, 25);
        tf_magic_speed_main.addActionListener(this);
        panels[0].add(tf_magic_speed_main);

        lab_tmp = new JLabel("補魔");
        lab_tmp.setBounds(620, 225 + 5 + 25, 200, 25);
        panels[0].add(lab_tmp);
        tf_magic_speed_sub = new JTextField();
        tf_magic_speed_sub.setBounds(700, 225 + 5 + 25, 80, 25);
        tf_magic_speed_sub.addActionListener(this);
        panels[0].add(tf_magic_speed_sub);

        cb_speed_auto = new JCheckBox("自動入力");
        cb_speed_auto.setSelected(true);
        cb_speed_auto.setBounds(420 + 280, 200 + 50 + 5 + 25, 80, 25);
        panels[0].add(cb_speed_auto);
        cb_speed_auto.addActionListener(this);

        lab_sp_rate = new JLabel("武器特性");
        lab_sp_sub = new JLabel("");
        lab_mag_rate = new JLabel("魔法発動率");
        lab_mag_delay = new JLabel("魔法ディレイ");
        lab_mag_power = new JLabel("魔法威力");
        tf_buki_sp_rate = new JTextField("0");
        tf_mag_rate = new JTextField("0.0");
        tf_mag_delay = new JTextField("0.0");
        tf_mag_power = new JTextField("0.0");
        tf_buki_sp_rate.setText("0.0");
        tf_mag_rate.setText("0.0");
        tf_mag_delay.setText("0.0");
        tf_mag_power.setText("0.0");
        lab_sp_rate.setBounds(420, 200 + 25 + 25 + 25 + 15 + 25, 100, 25);
        lab_sp_sub.setBounds(420 + 160, 200 + 25 + 25 + 25 + 15 + 25, 40, 25);
        lab_mag_rate.setBounds(420, 200 + 50 + 25 + 25 + 15 + 25, 100, 25);
        lab_mag_delay.setBounds(420 + 200, 200 + 25 + 25 + 25 + 15 + 25, 100, 25);
        lab_mag_power.setBounds(420 + 200, 200 + 50 + 25 + 25 + 15 + 25, 100, 25);
        tf_buki_sp_rate.setBounds(420 + 80, 200 + 25 + 25 + 25 + 15 + 25, 80, 25);
        tf_mag_rate.setBounds(420 + 80, 200 + 50 + 25 + 25 + 15 + 25, 80, 25);
        tf_mag_delay.setBounds(420 + 280, 200 + 25 + 25 + 25 + 15 + 25, 80, 25);
        tf_mag_power.setBounds(420 + 280, 200 + 50 + 25 + 25 + 15 + 25, 80, 25);
        panels[0].add(lab_sp_rate);
        panels[0].add(tf_buki_sp_rate);
        panels[0].add(lab_sp_sub);
        panels[0].add(lab_mag_rate);
        panels[0].add(tf_mag_rate);
        panels[0].add(lab_mag_delay);
        panels[0].add(tf_mag_delay);
        panels[0].add(lab_mag_power);
        panels[0].add(tf_mag_power);
        tf_buki_sp_rate.addActionListener(this);
        tf_mag_rate.addActionListener(this);
        tf_mag_delay.addActionListener(this);
        tf_mag_power.addActionListener(this);

        cb_mag_auto = new JCheckBox("自動入力");
        cb_mag_auto.setSelected(true);
        cb_mag_auto.setBounds(420 + 280, 200 + 50 + 25 + 25 + 25 + 15 + 25, 80, 25);
        panels[0].add(cb_mag_auto);
        cb_mag_auto.addActionListener(this);

        lab_tmp = new JLabel("魔法使用");
        lab_tmp.setBounds(420, 200 + 75 + 25 + 25 + 25 + 25 + 25, 80, 25);
        cb_magic = new WideComboBox();
        cb_magic.addItem("");
        cb_magic.setSelectedIndex(0);
        cb_magic.addActionListener(this);
        cb_magic.setBounds(420 + 80, 350 + 25 + 25, 80, 25);
        panels[0].add(lab_tmp);
        panels[0].add(cb_magic);

        lab_tmp = new JLabel("重量");
        lab_tmp.setBounds(420, 350 + 25 + 25 + 25, 150, 25);
        panels[0].add(lab_tmp);
        lab_tmp = new JLabel("所持可能量");
        lab_tmp.setBounds(620, 350 + 25 + 25 - 13 + 25, 80, 25);
        panels[0].add(lab_tmp);
        tf_weight = new JTextField();
        tf_weight.setBounds(700, 350 + 25 + 25, 80, 25);
        tf_weight.setHorizontalAlignment(SwingConstants.CENTER);
        tf_weight.setEditable(false);
        panels[0].add(tf_weight);
        tf_weight2 = new JTextField();
        tf_weight2.setBounds(700, 350 + 25 + 25 + 25, 80, 25);
        tf_weight2.setHorizontalAlignment(SwingConstants.CENTER);
        tf_weight2.setEditable(false);
        panels[0].add(tf_weight2);

        String[] w_list = {"33 %", "50 %", "66 %", "82 %"};
        cb_weight = new JComboBox(w_list);
        cb_weight.setBounds(500, 380 + 20 + 25, 80, 25);
        cb_weight.addActionListener(this);
        panels[0].add(cb_weight);

//        cb_weight_auto = new JCheckBox("自動入力");
//        cb_weight_auto.setSelected(true);
//        cb_weight_auto.setBounds(420 + 280, 380 + 25 + 20, 80, 25);
//        panels[0].add(cb_weight_auto);
//        cb_weight_auto.addActionListener(this);
        lab_tmp = new JLabel("耐性");
        lab_tmp.setBounds(420, 425 + 5 + 30, 80, 25);
        panels[0].add(lab_tmp);

        for (int i = 0; i < elem_list.length; i++) {
            lab_elem[i] = new JLabel();
            lab_elem[i].setBounds(420 + 60 + 80 * i, 350 + 25 + 50 + 5 + 30, 100, 25);
            panels[0].add(lab_elem[i]);
        }
        for (int i = 0; i < ailment_list.length; i++) {
            lab_ailment[i] = new JLabel();
            lab_ailment[i].setBounds(420 + 60 + 80 * (i % 4), 350 + 50 + 25 * (i / 4) + 50 + 5 + 30, 100, 25);
            panels[0].add(lab_ailment[i]);
        }

        //----------
        //パネル２
        //----------
        for (int i = 0; i < st_list.length; i++) {
            JLabel lab4 = new JLabel(st_list[i], SwingConstants.CENTER);
            lab4.setBounds(30 + 150 * i, 195, 100, 25);
            panels[1].add(lab4);
        }

        pure_status_bonus[0][0] = new JLabel("近距離ダメージ");
        pure_status_bonus[0][1] = new JLabel("近距離命中");
        pure_status_bonus[0][2] = new JLabel("近距離クリティカル");
        pure_status_bonus[0][3] = new JLabel("最大所持重量");
        pure_status_bonus[0][4] = new JLabel("");
        pure_status_bonus[0][5] = new JLabel("遠距離ダメージ");
        pure_status_bonus[0][6] = new JLabel("遠距離命中");
        pure_status_bonus[0][7] = new JLabel("遠距離クリティカル");
        pure_status_bonus[0][8] = new JLabel("AC");
        pure_status_bonus[0][9] = new JLabel("ER");
        pure_status_bonus[0][10] = new JLabel("HP増加");
        pure_status_bonus[0][11] = new JLabel("HPR");
        pure_status_bonus[0][12] = new JLabel("HPポーション");
        pure_status_bonus[0][13] = new JLabel("最大重量");
        pure_status_bonus[0][14] = new JLabel("");
        pure_status_bonus[0][15] = new JLabel("魔法ダメージ");
        pure_status_bonus[0][16] = new JLabel("魔法命中");
        pure_status_bonus[0][17] = new JLabel("魔法クリティカル");
        pure_status_bonus[0][18] = new JLabel("MB");
        pure_status_bonus[0][19] = new JLabel("MP消費減少");
        pure_status_bonus[0][20] = new JLabel("MP増加");
        pure_status_bonus[0][21] = new JLabel("MPR");
        pure_status_bonus[0][22] = new JLabel("MPポーション");
        pure_status_bonus[0][23] = new JLabel("MR");
        pure_status_bonus[0][24] = new JLabel("");

        for (int i = 0; i < pure_status_bonus[0].length; i++) {

            pure_status_bonus[1][i] = new JLabel("0");
            pure_status_bonus[0][i].setBounds(30 + 150 * (i / 5), 220 + 25 * (i % 5), 100, 25);
            pure_status_bonus[1][i].setBounds(130 + 150 * (i / 5), 220 + 25 * (i % 5), 50, 25);
            if (pure_status_bonus[0][i].getText().equals("")) {
                continue;
            }
            panels[1].add(pure_status_bonus[0][i]);
            panels[1].add(pure_status_bonus[1][i]);
        }

        lev.put(panels[1], 0, 350);
        lev.addActionListener(this);
        lev.setSelfCheck();

        String elixir_list[] = {"---", "STR", "DEX", "CON", "INT", "WIS",
            "CHA"};
        for (int i = 0; i < 5; i++) {
            cb_elixir[i] = new JComboBox(elixir_list);
            cb_elixir_level[i] = new JComboBox(lev_list);
            cb_elixir[i].setBounds(30 + 100 * i, 500, 50, 20);
            cb_elixir[i].addActionListener(this);
            cb_elixir_level[i].setBounds(30 + 100 * i, 520, 100, 20);
            cb_elixir_level[i].setSelectedItem(Integer.toString(50 + 5 * i));
            cb_elixir_level[i].addActionListener(this);
            panels[1].add(cb_elixir[i]);
            panels[1].add(cb_elixir_level[i]);
        }
        //----------
        //パネル３
        //----------
        int row = 0;
        int col = 0;

        lab_tmp = new JLabel("基本");
        lab_tmp.setBounds(200 * row, 20 * col++, 100, 20);
        panels[2].add(lab_tmp);

        cb_buff[ACC1] = new JCheckBox("1段加速");
        cb_buff[ACC1].setToolTipText("行動速度上昇");
        cb_buff[ACC1].setBounds(0, 20 * col++, 100, 20);

        String list_acc2[] = {"×1.3333", "×1.1547"};
        cb_buff_group[ACC2] = new WideComboBox(list_acc2);
        cb_buff_group[ACC2].setBounds(100, 20 * col, 80, 20);
        cb_buff[ACC2] = new JCheckBox("2段加速");
        cb_buff[ACC2].setToolTipText("行動速度上昇");
        cb_buff[ACC2].setBounds(0, 20 * col++, 100, 20);

        cb_buff[ACC3] = new JCheckBox("3段加速");
        cb_buff[ACC3].setToolTipText("行動速度上昇");
        cb_buff[ACC3].setBounds(0, 20 * col++, 100, 20);

        String list_str[] = {"+3", "+5", "+6", "+7"};
        cb_buff_group[B_STR] = new WideComboBox(list_str);
        cb_buff_group[B_STR].setBounds(100, 20 * col, 80, 20);
        cb_buff_group[B_STR].setSelectedIndex(1);
        cb_buff[B_STR] = new JCheckBox("STR");
        cb_buff[B_STR].setBounds(0, 20 * col++, 100, 20);

        String list_dex[] = {"+3", "+5", "+6", "+7"};
        cb_buff_group[B_DEX] = new WideComboBox(list_dex);
        cb_buff_group[B_DEX].setBounds(100, 20 * col, 80, 20);
        cb_buff_group[B_DEX].setSelectedIndex(1);
        cb_buff[B_DEX] = new JCheckBox("DEX");
        cb_buff[B_DEX].setBounds(0, 20 * col++, 100, 20);

        String list_ac[] = {"-2", "-5", "-6", "-7", "-10"};
        cb_buff_group[B_AC] = new WideComboBox(list_ac);
        cb_buff_group[B_AC].setBounds(100, 20 * col, 80, 20);
        cb_buff[B_AC] = new JCheckBox("AC");
        cb_buff[B_AC].setBounds(0, 20 * col++, 100, 20);

        String list_buki[] = {"+1", "+2", "+2 HIT+2", "+5"};
        cb_buff_group[BUKI] = new WideComboBox(list_buki);
        cb_buff_group[BUKI].setBounds(100, 20 * col, 80, 20);
        cb_buff_group[BUKI].setSelectedIndex(2);
        cb_buff[BUKI] = new JCheckBox("武器");
        cb_buff[BUKI].setBounds(0, 20 * col++, 100, 20);

        col++;

        lab_tmp = new JLabel("一般魔法");
        lab_tmp.setBounds(100 * row, 20 * col++, 200, 20);
        panels[2].add(lab_tmp);

        cb_buff[W_BA] = new JCheckBox("ブレスドアーマー");
        cb_buff[W_BA].setBounds(0, 20 * col++, 150, 20);
        cb_buff[W_BA].setToolTipText("AC-3");

        cb_buff[W_BSK] = new JCheckBox("バーサーカー");
        cb_buff[W_BSK].setBounds(0, 20 * col++, 150, 20);
        cb_buff[W_BSK].setToolTipText("AC+10 近接打撃+5 HP自然回復不可");

        cb_buff[W_DW] = new JCheckBox("ディクリースウェイト");
        cb_buff[W_DW].setBounds(0, 20 * col++, 150, 20);
        cb_buff[W_DW].setToolTipText("重量-150");

        cb_buff[W_ADS] = new JCheckBox("アドバンスドスピリッツ");
        cb_buff[W_ADS].setBounds(0, 20 * col++, 150, 20);
        cb_buff[W_ADS].setToolTipText("最大HP/MP+20%");

        col++;

        lab_tmp = new JLabel("君主魔法");
        lab_tmp.setBounds(100 * row, 20 * col++, 150, 20);
        panels[2].add(lab_tmp);

        cb_buff[P_G] = new JCheckBox("グローイングウエポン");
        cb_buff[P_G].setBounds(0, 20 * col++, 150, 20);
        cb_buff[P_G].setToolTipText("近接命中+5 追加打撃+5");

        cb_buff[P_B] = new JCheckBox("ブレイブメンタル");
        cb_buff[P_B].setBounds(0, 20 * col++, 150, 20);
        cb_buff[P_B].setToolTipText("一定確率で近接ダメージ1.5倍");

        cb_buff[P_S] = new JCheckBox("シャイニングオーラ");
        cb_buff[P_S].setBounds(0, 20 * col++, 150, 20);
        cb_buff[P_S].setToolTipText("AC-8");

        String list_ba[] = {"2-4人", "5-6人", "7-8人"};
        cb_buff_group[P_BA] = new WideComboBox(list_ba);
        cb_buff_group[P_BA].setBounds(100, 20 * col, 80, 20);
        cb_buff[P_BA] = new JCheckBox("ブレイブアバター");
        cb_buff[P_BA].setBounds(0, 20 * col++, 100, 20);
        cb_buff[P_BA].setToolTipText("PTメンバー数に応じた能力上昇");

        col++;

        lab_tmp = new JLabel("騎士技術");
        lab_tmp.setBounds(200 * row, 20 * col++, 200, 20);
        panels[2].add(lab_tmp);

        cb_buff[K_RA] = new JCheckBox("リダクションアーマー");
        cb_buff[K_RA].setBounds(0, 20 * col++, 150, 20);
        cb_buff[K_RA].setToolTipText("ダメージリダクション+(Lv-40)/10 小数点以下切り捨て");

        cb_buff[K_SC] = new JCheckBox("ソリッドキャリッジ");
        cb_buff[K_SC].setBounds(0, 20 * col++, 150, 20);
        cb_buff[K_SC].setToolTipText("盾装備時 ER+15");

        cb_buff[K_CB] = new JCheckBox("カウンターバリア");
        cb_buff[K_CB].setBounds(0, 20 * col++, 150, 20);
        cb_buff[K_CB].setToolTipText("両手剣装備時 一定確率で近接攻撃回避+反撃");

        cb_buff[K_BA] = new JCheckBox("バウンスアタック");
        cb_buff[K_BA].setBounds(0, 20 * col++, 150, 20);
        cb_buff[K_BA].setToolTipText("近接命中+6");

        col = 0;
        row = 1;

        lab_tmp = new JLabel("精霊魔法(共通)");
        lab_tmp.setBounds(200 * row, 20 * col++, 200, 20);
        panels[2].add(lab_tmp);

        cb_buff[E_RE] = new JCheckBox("レジストエレメント");
        cb_buff[E_RE].setBounds(200 * row, 20 * col++, 150, 20);
        cb_buff[E_RE].setToolTipText("全属性+10");
        cb_buff[E_RM] = new JCheckBox("レジストマジック");
        cb_buff[E_RM].setBounds(200 * row, 20 * col++, 150, 20);
        cb_buff[E_RM].setToolTipText("MR+10");
        cb_buff[E_CM] = new JCheckBox("クリアマインド");
        cb_buff[E_CM].setBounds(200 * row, 20 * col++, 150, 20);
        cb_buff[E_CM].setToolTipText("WIS+3");

        col++;

        lab_tmp = new JLabel("精霊魔法(火)");
        lab_tmp.setBounds(200 * row, 20 * col++, 200, 20);
        panels[2].add(lab_tmp);

        cb_buff[E_FW] = new JCheckBox("ファイアーウエポン");
        cb_buff[E_FW].setBounds(200 * row, 20 * col++, 150, 20);
        cb_buff[E_FW].setToolTipText("火属性追加打撃+4");
        cb_buff[E_BW] = new JCheckBox("バーニングウエポン");
        cb_buff[E_BW].setBounds(200 * row, 20 * col++, 150, 20);
        cb_buff[E_BW].setToolTipText("火属性追加打撃+6 近接命中+6");
        cb_buff[E_EF] = new JCheckBox("エレメンタルファイアー");
        cb_buff[E_EF].setBounds(200 * row, 20 * col++, 150, 20);
        cb_buff[E_EF].setToolTipText("一定確率で近接ダメージ1.5倍]");
        cb_buff[E_SF] = new JCheckBox("ソウルオブフレイム");
        cb_buff[E_SF].setBounds(200 * row, 20 * col++, 150, 20);
        cb_buff[E_SF].setToolTipText("武器ダメージが常に最大値 損傷しない");

        col++;

        lab_tmp = new JLabel("精霊魔法(水)");
        lab_tmp.setBounds(200 * row, 20 * col++, 200, 20);
        panels[2].add(lab_tmp);

        cb_buff[E_NT] = new JCheckBox("ネイチャーズタッチ");
        cb_buff[E_NT].setBounds(200 * row, 20 * col++, 150, 20);
        cb_buff[E_NT].setToolTipText("HPR+15");
        cb_buff[E_AP] = new JCheckBox("アクアプロテクター");
        cb_buff[E_AP].setBounds(200 * row, 20 * col++, 150, 20);
        cb_buff[E_AP].setToolTipText("ER+5");

        col++;

        lab_tmp = new JLabel("精霊魔法(風)");
        lab_tmp.setBounds(200 * row, 20 * col++, 200, 20);
        panels[2].add(lab_tmp);

        cb_buff[E_WS] = new JCheckBox("ウインドショット");
        cb_buff[E_WS].setBounds(200 * row, 20 * col++, 150, 20);
        cb_buff[E_WS].setToolTipText("遠距離命中+6");
        cb_buff[E_SE] = new JCheckBox("ストームアイ");
        cb_buff[E_SE].setBounds(200 * row, 20 * col++, 150, 20);
        cb_buff[E_SE].setToolTipText("風属性追加打撃+3 遠距離命中+2");
        cb_buff[E_SS] = new JCheckBox("ストームショット");
        cb_buff[E_SS].setBounds(200 * row, 20 * col++, 150, 20);
        cb_buff[E_SS].setToolTipText("風属性追加打撃+6 遠距離命中+3");

        col++;

        lab_tmp = new JLabel("精霊魔法(地)");
        lab_tmp.setBounds(200 * row, 20 * col++, 200, 20);
        panels[2].add(lab_tmp);

        cb_buff[E_EG] = new JCheckBox("アースガーディアン");
        cb_buff[E_EG].setBounds(200 * row, 20 * col++, 150, 20);
        cb_buff[E_EG].setToolTipText("DR+2");

        col = 0;
        row = 2;

        lab_tmp = new JLabel("闇の精霊魔法");
        lab_tmp.setBounds(200 * row, 20 * col++, 200, 20);
        panels[2].add(lab_tmp);

        cb_buff[D_BS] = new JCheckBox("バーニングスピリッツ");
        cb_buff[D_BS].setBounds(200 * row, 20 * col++, 150, 20);
        cb_buff[D_BS].setToolTipText("一定確率で近接ダメージ1.5倍");
        cb_buff[D_DB] = new JCheckBox("ダブルブレイク");
        cb_buff[D_DB].setBounds(200 * row, 20 * col++, 150, 20);
        cb_buff[D_DB].setToolTipText("一定確率で武器ダメージ2倍");
        cb_buff[D_UD] = new JCheckBox("アンキャニードッジ");
        cb_buff[D_UD].setBounds(200 * row, 20 * col++, 150, 20);
        cb_buff[D_UD].setToolTipText("DG+50");
        cb_buff[D_DE] = new JCheckBox("ドレスイベイジョン");
        cb_buff[D_DE].setBounds(200 * row, 20 * col++, 150, 20);
        cb_buff[D_DE].setToolTipText("ER+12");
        cb_buff[D_SA] = new JCheckBox("シャドウアーマー");
        cb_buff[D_SA].setBounds(200 * row, 20 * col++, 150, 20);
        cb_buff[D_SA].setToolTipText("MR+5");

        col++;

        lab_tmp = new JLabel("竜騎士秘技");
        lab_tmp.setBounds(200 * row, 20 * col++, 200, 20);
        panels[2].add(lab_tmp);

        cb_buff[R_DS] = new JCheckBox("ドラゴンスキン");
        cb_buff[R_DS].setBounds(200 * row, 20 * col++, 150, 20);
        cb_buff[R_DS].setToolTipText("DR+5");
        cb_buff[R_MB] = new JCheckBox("モータルボディー");
        cb_buff[R_MB].setBounds(200 * row, 20 * col++, 150, 20);
        cb_buff[R_MB].setToolTipText("一定確率で30ダメージの反撃");
        cb_buff[R_ANTHARAS] = new JCheckBox("覚醒[アンタラス]");
        cb_buff[R_ANTHARAS].setBounds(200 * row, 20 * col++, 150, 20);
        cb_buff[R_ANTHARAS].setToolTipText("AC-3 ホールド耐性+10");
        cb_buff[R_FAFURION] = new JCheckBox("覚醒[パプリオン]");
        cb_buff[R_FAFURION].setBounds(200 * row, 20 * col++, 150, 20);
        cb_buff[R_FAFURION].setToolTipText("重量オーバ時でも自然回復 凍結耐性+10");
        cb_buff[R_VALAKAS] = new JCheckBox("覚醒[ヴァラカス]");
        cb_buff[R_VALAKAS].setBounds(200 * row, 20 * col++, 150, 20);
        cb_buff[R_VALAKAS].setToolTipText("近接命中+5 スタン耐性+10");

        col++;

        lab_tmp = new JLabel("幻術魔法");
        lab_tmp.setBounds(200 * row, 20 * col++, 200, 20);
        panels[2].add(lab_tmp);

        cb_buff[I_MI] = new JCheckBox("ミラーイメージ");
        cb_buff[I_MI].setBounds(200 * row, 20 * col++, 150, 20);
        cb_buff[I_MI].setToolTipText("DG+50");
        cb_buff[I_CON] = new JCheckBox("コンセントレーション");
        cb_buff[I_CON].setBounds(200 * row, 20 * col++, 150, 20);
        cb_buff[I_CON].setToolTipText("MPR+4");
        cb_buff[I_PAT] = new JCheckBox("ペイシェンス");
        cb_buff[I_PAT].setBounds(200 * row, 20 * col++, 150, 20);
        cb_buff[I_PAT].setToolTipText("DR+2");
        cb_buff[I_INS] = new JCheckBox("インサイト");
        cb_buff[I_INS].setBounds(200 * row, 20 * col++, 150, 20);
        cb_buff[I_INS].setToolTipText("CHAを除く全ステータス+1");
        cb_buff[I_RW] = new JCheckBox("リデュースウェイト");
        cb_buff[I_RW].setBounds(200 * row, 20 * col++, 150, 20);
        cb_buff[I_RW].setToolTipText("重量-180");
        cb_buff[I_IO] = new JCheckBox("幻術[オーガ]");
        cb_buff[I_IO].setBounds(200 * row, 20 * col++, 150, 20);
        cb_buff[I_IO].setToolTipText("ダメージ+4 命中+4");
        cb_buff[I_IR] = new JCheckBox("幻術[リッチ]");
        cb_buff[I_IR].setBounds(200 * row, 20 * col++, 150, 20);
        cb_buff[I_IR].setToolTipText("SP+2");
        cb_buff[I_ID] = new JCheckBox("幻術[ダイアゴーレム]");
        cb_buff[I_ID].setBounds(200 * row, 20 * col++, 150, 20);
        cb_buff[I_ID].setToolTipText("AC-8");
        cb_buff[I_IA] = new JCheckBox("幻術[アバター]");
        cb_buff[I_IA].setBounds(200 * row, 20 * col++, 150, 20);
        cb_buff[I_IA].setToolTipText("与ダメージ+10 被ダメージ+5%");

        row = 3;
        col = 0;

        lab_tmp = new JLabel("戦士技術");
        lab_tmp.setBounds(200 * row, 20 * col++, 200, 20);
        panels[2].add(lab_tmp);

        cb_buff[F_AG] = new JCheckBox("アーマーガード");
        cb_buff[F_AG].setBounds(200 * row, 20 * col++, 150, 20);
        cb_buff[F_AG].setToolTipText("DR増加 -AC/5");
        cb_buff[F_CR] = new JCheckBox("クラッシュ");
        cb_buff[F_CR].setBounds(200 * row, 20 * col++, 150, 20);
        cb_buff[F_CR].setToolTipText("D一定確率でダメージ増加 Lv/2");
        cb_buff[F_FU] = new JCheckBox("フューリー");
        cb_buff[F_FU].setBounds(200 * row, 20 * col++, 150, 20);
        cb_buff[F_FU].setToolTipText("クラッシュ発動時、一定確率でダメージ2倍");
        cb_buff[F_TL] = new JCheckBox("タイタンロック");
        cb_buff[F_TL].setBounds(200 * row, 20 * col++, 150, 20);
        cb_buff[F_TL].setToolTipText("HP40%以下時一定確率で近接攻撃回避+反撃");
        cb_buff[F_TM] = new JCheckBox("タイタンマジック");
        cb_buff[F_TM].setBounds(200 * row, 20 * col++, 150, 20);
        cb_buff[F_TM].setToolTipText("HP40%以下時一定確率で魔法攻撃回避+反撃");
        cb_buff[F_TB] = new JCheckBox("タイタンブリッツ");
        cb_buff[F_TB].setBounds(200 * row, 20 * col++, 150, 20);
        cb_buff[F_TB].setToolTipText("HP40%以下時一定確率で遠距離攻撃回避+反撃");
        cb_buff[F_G] = new JCheckBox("ギガンティック");
        cb_buff[F_G].setBounds(200 * row, 20 * col++, 150, 20);
        cb_buff[F_G].setToolTipText("最大HP Lv/2% 増加");

        col++;
        lab_tmp = new JLabel("その他");
        lab_tmp.setBounds(200 * row, 20 * col++, 200, 20);
        panels[2].add(lab_tmp);

        cb_buff[ITEM_BLUE] = new JCheckBox("ブルーポーション");
        cb_buff[ITEM_BLUE].setBounds(200 * row, 20 * col++, 150, 20);
        cb_buff[ITEM_WIZP] = new JCheckBox("ウィズダムポーション");
        cb_buff[ITEM_WIZP].setBounds(200 * row, 20 * col++, 150, 20);

        String list_cooking[] = {"力強い和牛ステーキ", "素早い鮭の煮付", "賢い七面鳥焼き"};
        cb_buff_group[ITEM_COOKING] = new WideComboBox(list_cooking);
        cb_buff_group[ITEM_COOKING].setBounds(200 * row + 100, 20 * col, 80, 20);
        cb_buff[ITEM_COOKING] = new JCheckBox("料理");
        cb_buff[ITEM_COOKING].setBounds(200 * row, 20 * col++, 100, 20);

        String list_dessert[] = {"試練の鶏スープ", "幻想のバシリスクの卵スープ", "幻想のショートケーキ"};
        cb_buff_group[ITEM_DESSERT] = new WideComboBox(list_dessert);
        cb_buff_group[ITEM_DESSERT].setBounds(200 * row + 100, 20 * col, 80, 20);
        cb_buff[ITEM_DESSERT] = new JCheckBox("デザート");
        cb_buff[ITEM_DESSERT].setBounds(200 * row, 20 * col++, 100, 20);

        String list_breeze[] = {"治癒のポーション", "瞑想のポーション", "生命のポーション", "魔法のポーション",
            "魔法抵抗のポーション", "術士のポーション", "剣士のポーション"};
        cb_buff_group[ITEM_BREEZE] = new WideComboBox(list_breeze);
        cb_buff_group[ITEM_BREEZE].setBounds(200 * row + 100, 20 * col, 80, 20);
        cb_buff[ITEM_BREEZE] = new JCheckBox("潮風");
        cb_buff[ITEM_BREEZE].setBounds(200 * row, 20 * col++, 100, 20);

        String list_sea[] = {"ドラゴンの石", "憤怒のポーション", "集中のポーション", "腕力のポーション",
            "機敏のポーション", "体力のポーション", "知力のポーション", "精神のポーション"};
        cb_buff_group[ITEM_SEA] = new WideComboBox(list_sea);
        cb_buff_group[ITEM_SEA].setBounds(200 * row + 100, 20 * col, 80, 20);
        cb_buff[ITEM_SEA] = new JCheckBox("深海");
        cb_buff[ITEM_SEA].setBounds(200 * row, 20 * col++, 100, 20);

        String list_md[] = {"ウェアウルフ", "バグベアー", "サキュバス", "エルダー", "ストーンゴーレム",
            "クラスタシアン", "イエティ", "コカトリス", "シーダンサー", "スパルトイ", "スノーマン", "ラミア",
            "ブルート", "ブルート(努力する)", "ブルート(賢い)", "ブルート(聡明な)", "ブルート(光る)",
            "ブルート(眩しい)", "ジャイアント", "ジャイアント(努力する)", "ジャイアント(賢い)",
            "ジャイアント(聡明な)", "ジャイアント(光る)", "ジャイアント(眩しい)",
            "パック/パオ(0段階)", "パック/パオ(1段階)", "パック/パオ(2段階)", "パック/パオ(3段階)", "リッチ"};
        cb_buff_group[ITEM_MD] = new WideComboBox(list_md);
        cb_buff_group[ITEM_MD].setBounds(200 * row + 100, 20 * col, 80, 20);
        cb_buff[ITEM_MD] = new JCheckBox("マジックドール");
        cb_buff[ITEM_MD].setBounds(200 * row, 20 * col++, 100, 20);

        String list_md_op[] = {"AC-2", "AC-4", "AC-5/DR+2",
            "AC-1/MR+1", "AC-3/MR+5", "AC-5/MR+10",
            "MPR+1(同期)", "MPR+3(同期)", "MPR+7(同期)",
            "MPR+1(非同期)", "MPR+3(非同期)", "MPR+7(非同期)",
            "HP+10/MP+10", "HP+35/MP+35", "HP+60/MP+60",
            "近距離命中+1/遠距離命中+1", "近距離命中+2/遠距離命中+2", "近距離命中+4/遠距離命中+4"};
        cb_buff_group[ITEM_MD_OP] = new WideComboBox(list_md_op);
        cb_buff_group[ITEM_MD_OP].setBounds(200 * row + 100, 20 * col, 80, 20);
        cb_buff[ITEM_MD_OP] = new JCheckBox("パック/パオ OP");
        cb_buff[ITEM_MD_OP].setBounds(200 * row, 20 * col++, 100, 20);

        String list_koma[] = {"3種類", "5種類"};
        cb_buff_group[KOMA] = new WideComboBox(list_koma);
        cb_buff_group[KOMA].setBounds(200 * row + 100, 20 * col, 80, 20);
        cb_buff[KOMA] = new JCheckBox("コマ");
        cb_buff[KOMA].setBounds(200 * row, 20 * col++, 100, 20);

        cb_buff[SEC] = new JCheckBox("セキュリティ");
        cb_buff[SEC].setBounds(200 * row, 20 * col++, 150, 20);
        cb_buff[VIP] = new JCheckBox("VIP");
        cb_buff[VIP].setBounds(200 * row, 20 * col++, 150, 20);

        cb_buff[CLAY] = new JCheckBox("クレイ");
        cb_buff[CLAY].setBounds(200 * row, 20 * col++, 150, 20);

        for (JCheckBox buff : cb_buff) {
            if (buff != null) {
                panels[2].add(buff);
//                buff.addActionListener(this);
            }
        }

        for (JComboBox buff_group : cb_buff_group) {
            if (buff_group != null) {
                panels[2].add(buff_group);
//                buff_group.addActionListener(this);
            }
        }

        //----------
        //パネル４
        //----------
        lab_tmp = new JLabel("耐性", SwingConstants.CENTER);
        lab_tmp.setBounds(0, 0, 200, 25);
        panels[3].add(lab_tmp);
        for (int i = 0; i < elem_list.length; i++) {
            JLabel lab = new JLabel(elem_list[i], SwingConstants.CENTER);
            lab.setBounds(0, 25 + i * 25, 100, 25);
            panels[3].add(lab);
            s_target_res[i] = new JSlider(-100, 100, 0);
            s_target_res[i].setBounds(100, 25 + i * 25, 100, 25);
            s_target_res[i].addChangeListener(this);
            panels[3].add(s_target_res[i]);
            lab_target_resist[i] = new JLabel("0", SwingConstants.CENTER);
            lab_target_resist[i].setBounds(200, 25 + i * 25, 100, 25);
            panels[3].add(lab_target_resist[i]);
        }

        lab_tmp = new JLabel("MR", SwingConstants.CENTER);
        lab_tmp.setBounds(0, 125, 100, 25);
        panels[3].add(lab_tmp);
        s_target_mr = new JSlider(0, 200, 0);
        s_target_mr.setBounds(100, 125, 100, 25);
        s_target_mr.addChangeListener(this);
        panels[3].add(s_target_mr);
        lab_target_mr = new JLabel("0", SwingConstants.CENTER);
        lab_target_mr.setBounds(200, 125, 100, 25);
        panels[3].add(lab_target_mr);

        lab_tmp = new JLabel("対象", SwingConstants.CENTER);
        lab_tmp.setBounds(0, 175, 100, 25);
        panels[3].add(lab_tmp);
        String mode_list[] = {"NPC", "PC"};
        cb_mode_pc = new JComboBox(mode_list);
        cb_mode_pc.setBounds(100, 175, 100, 25);
        panels[3].add(cb_mode_pc);

        lab_tmp = new JLabel("AC", SwingConstants.CENTER);
        lab_tmp.setBounds(0, 200, 100, 25);
        panels[3].add(lab_tmp);
        String target_ac_list[] = new String[256];
        for (int i = 0; i < target_ac_list.length; i++) {
            target_ac_list[i] = Integer.toString(10 - i);
        }
        cb_target_ac = new JComboBox(target_ac_list);
        cb_target_ac.setBounds(100, 200, 100, 25);
        panels[3].add(cb_target_ac);
        cb_hittyuu = new JCheckBox("必中");
        cb_hittyuu.addActionListener(this);
        cb_hittyuu.setBounds(220, 200, 100, 25);
        panels[3].add(cb_hittyuu);

        String[] dr_list = new String[61];
        for (int i = 0; i <= 60; i++) {
            dr_list[i] = Integer.toString(i - 30);
        }

        cb_target_dr = new JComboBox(dr_list);
        cb_target_dr.setSelectedIndex(30);
        lab_tmp = new JLabel("DR", SwingConstants.CENTER);
        cb_target_dr.addActionListener(this);
        cb_target_dr.setBounds(100, 225, 100, 25);
        lab_tmp.setBounds(0, 225, 100, 25);
        panels[3].add(cb_target_dr);
        panels[3].add(lab_tmp);

        lab_tmp = new JLabel("DG", SwingConstants.CENTER);
        lab_tmp.setBounds(0, 250, 100, 25);
        panels[3].add(lab_tmp);
        String dg_list[] = {"+50", "0", "-50"};
        cb_target_dg = new JComboBox(dg_list);
        cb_target_dg.setSelectedIndex(1);
        cb_target_dg.addActionListener(this);

        cb_target_dg.setBounds(100, 250, 100, 25);
        panels[3].add(cb_target_dg);

        cb_sonsyou = new JCheckBox("損傷");
        cb_sonsyou.addActionListener(this);
        cb_sonsyou.setBounds(220, 175, 100, 25);
        panels[3].add(cb_sonsyou);

        lab_tmp = new JLabel("新規設定", SwingConstants.CENTER);
        lab_tmp.setBounds(420, 25, 100, 25);
        panels[3].add(lab_tmp);
        tf_res_name = new JTextField("");
        tf_res_name.setBounds(520, 25, 100, 25);
        panels[3].add(tf_res_name);
        bt_save_res = new JButton("作成");
        bt_save_res.setActionCommand("save_res");
        bt_save_res.addActionListener(this);
        bt_save_res.setBounds(620, 25, 100, 25);
        panels[3].add(bt_save_res);

        lab_tmp = new JLabel("設定リスト", SwingConstants.CENTER);
        lab_tmp.setBounds(420, 50, 100, 25);
        panels[3].add(lab_tmp);
        cb_res = new JComboBox();
        cb_res.setBounds(520, 50, 100, 25);
        panels[3].add(cb_res);
        bt_load_res = new JButton("読み込み");
        bt_load_res.setActionCommand("load_res");
        bt_load_res.addActionListener(this);
        bt_load_res.setBounds(620, 50, 100, 25);
        panels[3].add(bt_load_res);
        bt_ow_res = new JButton("上書き");
        bt_ow_res.setActionCommand("ow_res");
        bt_ow_res.addActionListener(this);
        bt_ow_res.setBounds(620, 75, 100, 25);
        panels[3].add(bt_ow_res);
        bt_del_res = new JButton("削除");
        bt_del_res.setActionCommand("del_res");
        bt_del_res.addActionListener(this);
        bt_del_res.setBounds(620, 100, 100, 25);
        panels[3].add(bt_del_res);

        lab_tmp = new JLabel("起動時", SwingConstants.CENTER);
        lab_tmp.setBounds(420, 125, 100, 25);
        panels[3].add(lab_tmp);
        JButton bt_default = new JButton("変更");
        bt_default.setBounds(620, 125, 100, 25);
        bt_default.addActionListener(this);
        bt_default.setActionCommand("change_default");
        panels[3].add(bt_default);
        lab_default = new JLabel();
        lab_default.setHorizontalAlignment(SwingConstants.CENTER);
        lab_default.setBounds(520, 125, 100, 25);
        panels[3].add(lab_default);

        refresh();

        lab_tmp = new JLabel("簡易計算機", SwingConstants.CENTER);
        lab_tmp.setBounds(420, 250, 200, 25);
        panels[3].add(lab_tmp);

        lab_tmp = new JLabel("HP", SwingConstants.CENTER);
        lab_tmp.setBounds(420, 300, 100, 25);
        panels[3].add(lab_tmp);
        tf_e_hp = new JTextField("4000");
        tf_e_hp.setBounds(520, 300, 100, 25);
        tf_e_hp.addActionListener(this);
        panels[3].add(tf_e_hp);

        lab_tmp = new JLabel("HPR [/5sec]", SwingConstants.CENTER);
        lab_tmp.setBounds(420, 325, 100, 25);
        panels[3].add(lab_tmp);
        tf_e_hpr = new JTextField("250");
        tf_e_hpr.setBounds(520, 325, 100, 25);
        tf_e_hpr.addActionListener(this);
        panels[3].add(tf_e_hpr);

        lab_tmp = new JLabel("タイプ", SwingConstants.CENTER);
        lab_tmp.setBounds(420, 350, 100, 25);
        panels[3].add(lab_tmp);
        String[] type_list = {"通常", "悪魔", "不死"};
        cb_e_type = new JComboBox(type_list);
        cb_e_type.setBounds(520, 350, 100, 25);
        cb_e_type.addActionListener(this);
        panels[3].add(cb_e_type);

        lab_tmp = new JLabel("サイズ", SwingConstants.CENTER);
        lab_tmp.setBounds(420, 375, 100, 25);
        panels[3].add(lab_tmp);
        String[] size_list = {"小", "大"};
        cb_e_size = new JComboBox(size_list);
        cb_e_size.setBounds(520, 375, 100, 25);
        cb_e_size.addActionListener(this);
        panels[3].add(cb_e_size);

        lab_tmp = new JLabel("戦闘時間(推定)", SwingConstants.CENTER);
        lab_tmp.setBounds(420, 425, 100, 25);
        panels[3].add(lab_tmp);
        lab_time = new JLabel();
        lab_time.setBounds(520, 425, 100, 25);
        panels[3].add(lab_time);
        
        
        try {
            try (BufferedReader br = new BufferedReader(new FileReader("./res/default"))) {
                lab_default.setText(br.readLine());
                pre_load_res();
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }

//        String[] kago_list = {"なし", "水竜", "ハロウィン"};
//        cb_kago = new JComboBox(kago_list);
//        JLabel kagolab = new JLabel("加護", SwingConstants.CENTER);
//        kagolab.setBounds(0, 350, 100, 25);
//        kago.setBounds(100, 350, 100, 25);
//        panel4.add(kago);
//        panel4.add(kagolab);
//        kago.addActionListener(data);
//
//        i2h = new JToggleButton("I2H");
//        i2h.setBounds(100, 375, 100, 25);
//        panel4.add(i2h);
//        i2h.addActionListener(data);
//
//        ab = new JToggleButton("AB");
//        ab.setBounds(100, 400, 100, 25);
//        panel4.add(ab);
//        ab.addActionListener(data);
//
//        JLabel speedlab = new JLabel("攻撃速度", SwingConstants.CENTER);
//        speedlab.setBounds(0, 425, 100, 25);
//        panel4.add(speedlab);
//        enemy_speed = new JFormattedTextField(60.0);
//        enemy_speed.setBounds(100, 425, 100, 25);
//        enemy_speed.addActionListener(data);
//        panel4.add(enemy_speed);
//
//        cb = new JToggleButton("CB");
//        cb.setBounds(100, 450, 100, 25);
//        cb.addActionListener(data);
//        panel4.add(cb);
//
//        hangyaku = new JToggleButton("反逆者の盾");
//        String[] en = {"+0", "+1", "+2", "+3", "+4", "+5", "+6", "+7", "+8", "+9"};
//        hangyaku_enchant = new JComboBox(en);
//        hangyaku.setBounds(100, 475, 100, 25);
//        hangyaku_enchant.setBounds(200, 475, 100, 25);
//        panel4.add(hangyaku);
//        panel4.add(hangyaku_enchant);
        tabpane.addChangeListener(this);
        init_mem();
        calc.update();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getActionCommand().equals("change_default")) {
            try {
                lab_default.setText((String) cb_res.getSelectedItem());
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("./res/default"))) {
                    bw.write((String) cb_res.getSelectedItem());
                    bw.flush();
                }
            } catch (IOException ex) {
            }
            return;
        }

        if (e.getActionCommand().equals("save_res")) {
            String s = (String) cb_res.getSelectedItem();
            save_res();
            refresh();
            cb_res.setSelectedItem(s);
            return;
        }
        if (e.getActionCommand().equals("load_res")) {
            load_res();
            return;
        }

        if (e.getActionCommand().equals("del_res")) {
            del_res();
            refresh();
            return;
        }

        if (e.getActionCommand().equals("save")) {
            mem.copy_to_mem(curr);

            JFileChooser fc = new JFileChooser();
            fc.setFileFilter(new FileNameExtensionFilter("*.xml", "xml"));
            int ret = fc.showSaveDialog(this);

            File f = null;
            if (ret == JFileChooser.APPROVE_OPTION) {
                f = fc.getSelectedFile();
            }
            if (f != null) {
                if (!f.getName().endsWith(".xml")) {
                    f = new File(fc.getSelectedFile().getPath() + ".xml");
                }
                try {
                    try (FileOutputStream fos = new FileOutputStream(f)) {
                        StreamResult result = new StreamResult(fos);

                        TransformerFactory transFactory = TransformerFactory.newInstance();
                        Transformer transformer = transFactory.newTransformer();

                        transformer.setOutputProperty("encoding", "UTF-8");
                        transformer.setOutputProperty("indent", "yes");

                        DOMSource source = new DOMSource(createDocument());
                        transformer.transform(source, result);
                    }
                } catch (IOException | IllegalArgumentException | ParserConfigurationException | TransformerException ex) {

                }
            }
            return;
        }
        if (e.getActionCommand().equals("load")) {
            JFileChooser fc = new JFileChooser();
            fc.setFileFilter(new FileNameExtensionFilter("*.sim *.xml", "sim", "xml"));
            int ret = fc.showOpenDialog(this);
            File f = null;
            if (ret == JFileChooser.APPROVE_OPTION) {
                f = fc.getSelectedFile();
            }
            if (f != null) {
                init_mem();
                try {
                    if (f.getName().endsWith(".xml")) {
                        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                        DocumentBuilder builder = factory.newDocumentBuilder();
                        Document document = builder.parse(f);
                        loadDocument(document);
                    }
                } catch (IOException | NumberFormatException ex) {
                } catch (ParserConfigurationException | SAXException ex) {
                }
            }
            return;
        }

        if (isLoading) {
            return;
        }

        if (e.getActionCommand().equals("アロー")) {
            switch (calc.buki.type) {
                case "ボウ":
                    try {
                        if (cb_arrow.getSelectedIndex() == -1) {
                            InputStream is = eq_files.getInputStream(arrow_entrys.get(0));
                            InputStreamReader isr = new InputStreamReader(is);
                            try (BufferedReader br = new BufferedReader(isr)) {
                                calc.buki.loadArrow(br);
                            }
                        } else {
                            InputStream is = eq_files.getInputStream(arrow_entrys.get(cb_arrow.getSelectedIndex()));
                            InputStreamReader isr = new InputStreamReader(is);
                            try (BufferedReader br = new BufferedReader(isr)) {
                                calc.buki.loadArrow(br);
                            }
                        }
                    } catch (IOException ex) {
                        System.out.println(ex);
                    }
                    break;
                case "ガントレット":
                    try {
                        if (cb_arrow.getSelectedIndex() == -1) {
                            InputStream is = eq_files.getInputStream(sting_entrys.get(0));
                            InputStreamReader isr = new InputStreamReader(is);
                            try (BufferedReader br = new BufferedReader(isr)) {
                                calc.buki.loadArrow(br);
                            }
                        } else {
                            InputStream is = eq_files.getInputStream(sting_entrys.get(cb_arrow.getSelectedIndex()));
                            InputStreamReader isr = new InputStreamReader(is);
                            try (BufferedReader br = new BufferedReader(isr)) {
                                calc.buki.loadArrow(br);
                            }
                        }
                    } catch (IOException ex) {
                        System.out.println(ex);
                    }
            }
        }

        //装備の読み込み
        for (int i = 0; i < eq_list.length; i++) {
            if (e.getSource().equals(cb_eq[i])) {
                try {
                    if (cb_eq[i].getSelectedIndex() >= 0) {
                        InputStream is = eq_files.getInputStream(eq_entrys[i].get(cb_eq[i].getSelectedIndex()));
                        InputStreamReader isr = new InputStreamReader(is);
                        BufferedReader br = new BufferedReader(isr);
                        switch (i) {
                            case 0:
                                calc.buki.load(br);
                                br.close();

                                switch (calc.buki.type) {
                                    case "クロウ":
                                        tf_buki_sp_rate.setEnabled(true);
                                        tf_buki_sp_rate.setText(Double.toString(calc.buki.critical_rate));
                                        break;
                                    case "デュアルブレード":
                                        tf_buki_sp_rate.setEnabled(true);
                                        tf_buki_sp_rate.setText(Double
                                                .toString(calc.buki.double_hit_rate));
                                        break;
                                    case "チェーンソード":
                                        tf_buki_sp_rate.setEnabled(true);
                                        tf_buki_sp_rate.setText(Double
                                                .toString(calc.buki.week_point_exposure));
                                        break;
                                    default:
                                        if (cb_cls.getSelectedIndex() == F && !calc.buki.two_hands && calc.buki.type.equals("鈍器")) {
                                            tb_blessed2.setEnabled(true);
                                            cb_eq[1].setEnabled(true);
                                            cb_eq_en[1].setEnabled(true);
                                        } else {
                                            tb_blessed2.setEnabled(false);
                                            cb_eq[1].setEnabled(false);
                                            cb_eq_en[1].setEnabled(false);
                                            cb_eq[1].setSelectedIndex(0);
                                            cb_eq_en[1].setSelectedIndex(0);
                                        }
                                        tf_buki_sp_rate.setEnabled(false);
                                        tf_buki_sp_rate.setText("0.0");
                                        break;
                                }

                                //魔法ディレイ
                                if (calc.buki.magic_name.equals("")) {
                                    tf_mag_delay.setEnabled(false);
                                    tf_mag_delay.setText("0.0");
                                    tf_mag_power.setEnabled(false);
                                    tf_mag_delay.setText("0.0");
                                } else {
                                    tf_mag_delay.setEnabled(true);
                                    tf_mag_delay.setText(Double.toString(calc.buki.magic_delay));
                                    tf_mag_power.setEnabled(true);
                                    tf_mag_power.setText(Double.toString(calc.buki.magic_power));
                                }

                                cb_eq_en[i].removeAllItems();
                                for (int n = 0; n <= calc.buki.max_enchant; n++) {
                                    cb_eq_en[i].addItem(n);
                                }
                                // ロード時に安全圏まで強化
                                if (calc.buki.safety != 0) {
                                    cb_eq_en[i].setSelectedIndex(calc.buki.safety + 1);
                                }
                                calc.buki.checkEnchant();

                                if (calc.buki.element_enchant) {
                                    cb_elem_1.setEnabled(true);
                                } else {
                                    cb_elem_1.setSelectedIndex(0);
                                    cb_elem_1.setEnabled(false);
                                }

                                //両手武器は盾装備を解除
                                if (calc.buki.two_hands) {
                                    if (calc.bougu[0].type.equals("シールド")) {
                                        cb_eq[1].setSelectedIndex(0);
                                    }
                                }
                                try {
                                    cb_arrow.removeAllItems();
                                    switch (calc.buki.type) {
                                        case "ボウ":
                                            for (ZipEntry arrow : arrow_entrys) {
                                                InputStream is2 = eq_files.getInputStream(arrow);
                                                InputStreamReader isr2 = new InputStreamReader(is2);
                                                BufferedReader br2 = new BufferedReader(isr2);

                                                String line;
                                                String name = "";
                                                while ((line = br2.readLine()) != null) {
                                                    if (line.startsWith("name=")) {
                                                        name = line.split("=")[1];
                                                    }
                                                }
                                                cb_arrow.addItem(name);
                                            }
                                            break;
                                        case "ガントレット":
                                            for (ZipEntry sting : sting_entrys) {
                                                InputStream is2 = eq_files.getInputStream(sting);
                                                InputStreamReader isr2 = new InputStreamReader(is2);
                                                BufferedReader br2 = new BufferedReader(isr2);

                                                String line;
                                                String name = "";
                                                while ((line = br.readLine()) != null) {
                                                    if (line.startsWith("name=")) {
                                                        name = line.split("=")[1];
                                                    }
                                                }
                                                cb_arrow.addItem(name);
                                            }
                                    }

                                } catch (IOException ex) {
                                    System.out.println(ex);
                                }
                                break;
                            case 1:
                                calc.buki2.load(br);
                                br.close();

                                cb_eq_en[i].removeAllItems();
                                for (int n = 0; n <= calc.buki2.max_enchant; n++) {
                                    cb_eq_en[i].addItem(n);
                                }
                                // ロード時に安全圏まで強化
                                if (calc.buki2.safety != 0) {
                                    cb_eq_en[i].setSelectedIndex(calc.buki2.safety + 1);
                                }
                                calc.buki2.checkEnchant();

                                if (calc.buki2.element_enchant) {
                                    cb_elem_2.setEnabled(true);
                                } else {
                                    cb_elem_2.setSelectedIndex(0);
                                    cb_elem_2.setEnabled(false);
                                }
                                break;
                            default:
                                calc.bougu[i - 2].load(br);
                                br.close();
                                cb_eq_en[i].removeAllItems();
                                for (int n = 0; n <= calc.bougu[i - 2].max_enchant; n++) {
                                    cb_eq_en[i].addItem(n);
                                }
                                // 安全圏0以外の装備をロード時に安全圏+1まで強化
                                if (calc.bougu[i - 2].safety != 0) {
                                    cb_eq_en[i]
                                            .setSelectedIndex(calc.bougu[i - 2].safety + 1);
                                }
                                calc.bougu[i - 2].checkEnchant();
                                if (eq_list[i].equals("シャツ")) {
                                    cb_ts_elem.setSelectedIndex(0);

                                    if (calc.bougu[i - 2].element_enchant) {
                                        cb_ts_elem.setEnabled(true);
                                        tb_ts_sp.setEnabled(false);
                                        tb_ts_sp.setSelected(false);
                                    } else if (calc.bougu[i - 2].name.contains("の魔法抵抗")
                                            || calc.bougu[i - 2].name.contains("のスタン耐性")
                                            || calc.bougu[i - 2].name.contains("のホールド耐性")) {
                                        tb_ts_sp.setEnabled(true);
                                        cb_ts_elem.setSelectedIndex(0);
                                        cb_ts_elem.setEnabled(false);
                                    } else {
                                        cb_ts_elem.setSelectedIndex(0);
                                        cb_ts_elem.setEnabled(false);
                                        tb_ts_sp.setEnabled(false);
                                        tb_ts_sp.setSelected(false);
                                    }
                                }
                                if (calc.buki.two_hands) {
                                    if (calc.bougu[0].type.equals("シールド")) {
                                        cb_eq[2].setSelectedIndex(0);
                                        cb_eq_en[2].setSelectedIndex(0);
                                    }
                                }
                                if (cb_eq[1].getSelectedIndex() > 0) {
                                    cb_eq[2].setSelectedIndex(0);
                                    cb_eq[2].setSelectedIndex(0);
                                }
                        }
                    }

                } catch (IOException ex) {
                    Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        if (e.getActionCommand().equals("reset")) {
            init_mem();
            return;
        }

        if (e.getActionCommand().contains("up")) {
            switch (e.getActionCommand().split("/")[0]) {
                case "STR":
                    calc.addRem(STR);
                    break;
                case "DEX":
                    calc.addRem(DEX);
                    break;
                case "CON":
                    calc.addRem(CON);
                    break;
                case "WIS":
                    calc.addRem(WIS);
                    break;
                case "INT":
                    calc.addRem(INT);
                    break;
                case "CHA":
                    calc.addRem(CHA);
                    break;
            }
        }
        if (e.getActionCommand().contains("down")) {
            switch (e.getActionCommand().split("/")[0]) {
                case "STR":
                    calc.removeRem(STR);
                    break;
                case "DEX":
                    calc.removeRem(DEX);
                    break;
                case "CON":
                    calc.removeRem(CON);
                    break;
                case "WIS":
                    calc.removeRem(WIS);
                    break;
                case "INT":
                    calc.removeRem(INT);
                    break;
                case "CHA":
                    calc.removeRem(CHA);
                    break;
            }
        }

        calc.buki.enchant = cb_eq_en[0].getSelectedIndex();
        calc.buki2.enchant = cb_eq_en[0].getSelectedIndex();
        calc.buki.checkEnchant();
        calc.buki2.checkEnchant();
        for (int i = 2; i < eq_list.length; i++) {
            calc.bougu[i - 2].enchant = cb_eq_en[i].getSelectedIndex();
            calc.bougu[i - 2].checkEnchant();
        }
        for (int i = 0; i < elem_list.length; i++) {
            calc.bougu[3].op.element_resist[i] = cb_ts_elem.getSelectedIndex() * 2;
        }
        calc.update();
    }

    final void refresh() {
        File res = new File("./res");
        if (!res.exists()) {
            res.mkdir();
        }

        File list[] = res.listFiles((File dir, String name1) -> name1.endsWith(".txt"));
        cb_res.removeAllItems();
        for (File f : list) {
            cb_res.addItem(f.getName().split(".txt")[0]);
        }
    }

    final void del_res() {
        File res = new File("./res/" + (String) cb_res.getSelectedItem() + ".txt");
        res.delete();
    }

    final void pre_load_res() {
        
        
        try {
            File res = new File("./res/" + lab_default.getText() + ".txt");
            try (BufferedReader reader = new BufferedReader(new FileReader(res))) {
                for (int i = 0; i < elem_list.length; i++) {
                    s_target_res[i].setValue(Integer.parseInt(reader.readLine()));
                }
                s_target_mr.setValue(Integer.parseInt(reader.readLine()));
                cb_mode_pc.setSelectedIndex(Integer.parseInt(reader.readLine()));
                cb_target_ac.setSelectedIndex(Integer.parseInt(reader.readLine()));
                cb_target_dr.setSelectedIndex(Integer.parseInt(reader.readLine()));
                cb_target_dg.setSelectedIndex(Integer.parseInt(reader.readLine()));
                cb_sonsyou.setSelected(Boolean.parseBoolean(reader.readLine()));
                cb_hittyuu.setSelected(Boolean.parseBoolean(reader.readLine()));
                
                tf_e_hp.setText(reader.readLine());
                tf_e_hpr.setText(reader.readLine());
                cb_e_type.setSelectedItem(reader.readLine());
                cb_e_size.setSelectedItem(reader.readLine());
            }
        } catch (IOException ex) {
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    final void load_res() {
        try {
            File res = new File("./res/" + (String) cb_res.getSelectedItem() + ".txt");
            try (BufferedReader reader = new BufferedReader(new FileReader(res))) {
                for (int i = 0; i < elem_list.length; i++) {
                    s_target_res[i].setValue(Integer.parseInt(reader.readLine()));
                }
                s_target_mr.setValue(Integer.parseInt(reader.readLine()));
                cb_mode_pc.setSelectedIndex(Integer.parseInt(reader.readLine()));
                cb_target_ac.setSelectedIndex(Integer.parseInt(reader.readLine()));
                cb_target_dr.setSelectedIndex(Integer.parseInt(reader.readLine()));
                cb_target_dg.setSelectedIndex(Integer.parseInt(reader.readLine()));
                cb_sonsyou.setSelected(Boolean.parseBoolean(reader.readLine()));
                cb_hittyuu.setSelected(Boolean.parseBoolean(reader.readLine()));
                
                tf_e_hp.setText(reader.readLine());
                tf_e_hpr.setText(reader.readLine());
                cb_e_type.setSelectedItem(reader.readLine());
                cb_e_size.setSelectedItem(reader.readLine());
            }
        } catch (IOException ex) {
        }
    }

    final void save_res() {
        if (!"".equals(tf_res_name.getText())) {
            try {
                File res = new File("./res/" + tf_res_name.getText() + ".txt");
                if (!res.exists()) {
                    res.createNewFile();
                }
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(res))) {
                    for (int i = 0; i < elem_list.length; i++) {
                        writer.write(Integer.toString(s_target_res[i].getValue()));
                        writer.newLine();
                    }
                    writer.write(Integer.toString(s_target_mr.getValue()));
                    writer.newLine();
                    writer.write(Integer.toString(cb_mode_pc.getSelectedIndex()));
                    writer.newLine();
                    writer.write(Integer.toString(cb_target_ac.getSelectedIndex()));
                    writer.newLine();
                    writer.write(Integer.toString(cb_target_dr.getSelectedIndex()));
                    writer.newLine();
                    writer.write(Integer.toString(cb_target_dg.getSelectedIndex()));
                    writer.newLine();
                    writer.write(Boolean.toString(cb_sonsyou.isSelected()));
                    writer.newLine();
                    writer.write(Boolean.toString(cb_hittyuu.isSelected()));
                    writer.newLine();
                    writer.write(tf_e_hp.getText());
                    writer.newLine();
                    writer.write(tf_e_hpr.getText());
                    writer.newLine();
                    writer.write((String)cb_e_type.getSelectedItem());
                    writer.newLine();
                    writer.write((String)cb_e_size.getSelectedItem());
                    writer.flush();
                }
            } catch (IOException ex) {
            }
            tf_res_name.setText("");
        }
    }

    boolean isLoading = false;

    final void loadEquip() {
        isLoading = true;
        try {
            Charset S_JIS = Charset.forName("Shift_JIS");
            eq_files = new ZipFile("./data/E.zip", S_JIS);
            arrow_entrys.clear();

            for (int i = 0; i < eq_list.length; i++) {
                cb_eq[i].removeAllItems();
                eq_entrys[i].clear();

                String eq = "";
                Enumeration enumeration = eq_files.entries();
                while (enumeration.hasMoreElements()) {
                    ZipEntry entry = (ZipEntry) enumeration.nextElement();

                    if (entry.getName().startsWith("E/アロー/a") && i == 0) {
                        arrow_entrys.add(entry);
                    }
                    if (entry.getName().startsWith("E/アロー/s") && i == 0) {
                        sting_entrys.add(entry);
                    }

                    if (entry.getName().startsWith("E/" + eq_list[i])) {
                        try (InputStream is = eq_files.getInputStream(entry); InputStreamReader ir = new InputStreamReader(is); BufferedReader br = new BufferedReader(ir)) {

                            String line;
                            while ((line = br.readLine()) != null) {
                                if (line.startsWith("装備=")) {
                                    eq = line;
                                }
                            }
                            if (eq.contains(class_list[cb_cls.getSelectedIndex()]) || eq.contains("ALL")) {
                                eq_entrys[i].add(entry);
                            }
                        }
                    }
                }

                try {
                    for (int j = 0; j < eq_entrys[i].size(); j++) {

                        InputStream is = eq_files.getInputStream(eq_entrys[i].get(j));
                        InputStreamReader ir = new InputStreamReader(is);
                        BufferedReader br = new BufferedReader(ir);
                        String line;
                        String name = "";
                        while ((line = br.readLine()) != null) {
                            if (line.startsWith("name=")) {
                                name = line.split("=")[1];
                            }
                        }
                        cb_eq[i].addItem(name);

                    }
                } catch (IOException e) {
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(UI.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        isLoading = false;

    }

    class Memory implements ActionListener {

        String[][] EQ;//装備名
        int[][] EN;//装備エンチャ
        boolean[] BL1;//祝福1
        boolean[] BL2;//祝福2
        int[] ELEM1;//武器属性1
        int[] ELEM2;//武器属性2
        int[] TS_ELEM;//TS印象
        String[] ARROW;//矢
        double[] SP_R;//特性発動率
        double[] MAG_R;//魔法発動率
        double[] MAG_D;//魔法ディレイ
        double[] MAG_P;//魔法威力
        boolean[] TS_SP;//特性TS

        final int CH = 3;

        private Memory() {
            this.EQ = new String[eq_list.length][CH];
            this.EN = new int[eq_list.length][CH];
            this.BL1 = new boolean[CH];
            this.ELEM1 = new int[CH];
            this.BL2 = new boolean[CH];
            this.ELEM2 = new int[CH];
            this.TS_ELEM = new int[CH];
            this.ARROW = new String[CH];
            this.SP_R = new double[CH];
            this.MAG_R = new double[CH];
            this.MAG_D = new double[CH];
            this.MAG_P = new double[CH];
            this.TS_SP = new boolean[CH];
            for (int n = 0; n < CH; n++) {
                for (int i = 0; i < eq_list.length; i++) {
                    this.EQ[i][n] = eq_list[i];
                    this.EN[i][n] = 0;
                }
                this.BL1[n] = false;
                this.ELEM1[n] = 0;
                this.BL2[n] = false;
                this.ELEM2[n] = 0;
                this.TS_ELEM[n] = 0;
                this.ARROW[n] = "";
                this.SP_R[n] = 0;
                this.MAG_R[n] = -1;
                this.MAG_D[n] = 0;
                this.MAG_P[n] = 0;
                this.TS_SP[n] = false;
            }
        }

        void clear() {
            for (int n = 0; n < CH; n++) {
                for (int i = 0; i < eq_list.length; i++) {
                    this.EQ[i][n] = eq_list[i];
                    this.EN[i][n] = 0;
                }
                this.BL1[n] = false;
                this.ELEM1[n] = 0;
                this.BL2[n] = false;
                this.ELEM2[n] = 0;
                this.TS_ELEM[n] = 0;
                this.ARROW[n] = "";
                this.SP_R[n] = 0;
                this.MAG_R[n] = -1;
                this.MAG_D[n] = 0;
                this.MAG_P[n] = 0;
                this.TS_SP[n] = false;
            }
        }

        void copy_to_mem(int channel) {
            for (int i = 0; i < eq_list.length; i++) {
                if (cb_eq[i].getSelectedItem() != null) {
                    this.EQ[i][channel] = cb_eq[i].getSelectedItem().toString();
                }
                this.EN[i][channel] = cb_eq_en[i].getSelectedIndex();
            }
            this.BL1[channel] = tb_blessed1.isSelected();
            this.ELEM1[channel] = cb_elem_1.getSelectedIndex();
            this.BL2[channel] = tb_blessed2.isSelected();
            this.ELEM2[channel] = cb_elem_2.getSelectedIndex();
            this.TS_ELEM[channel] = cb_ts_elem.getSelectedIndex();
            if (cb_arrow.getSelectedItem() != null) {
                this.ARROW[channel] = cb_arrow.getSelectedItem().toString();
            }
            this.SP_R[channel] = Double.parseDouble(tf_buki_sp_rate.getText());
            this.MAG_R[channel] = Double.parseDouble(tf_mag_rate.getText());
            this.MAG_D[channel] = Double.parseDouble(tf_mag_delay.getText());
            this.MAG_P[channel] = Double.parseDouble(tf_mag_power.getText());
            this.TS_SP[channel] = tb_ts_sp.isSelected();
        }

        private void load_from_mem(int channel) {
            for (int i = 0; i < eq_list.length; i++) {
                cb_eq[i].setSelectedIndex(0);
                cb_eq[i].setSelectedItem(this.EQ[i][channel]);
                cb_eq_en[i].setSelectedIndex(this.EN[i][channel]);
            }
            tb_blessed1.setSelected(this.BL1[channel]);
            cb_elem_1.setSelectedIndex(this.ELEM1[channel]);
            tb_blessed2.setSelected(this.BL2[channel]);
            cb_elem_2.setSelectedIndex(this.ELEM2[channel]);
            cb_ts_elem.setSelectedIndex(this.TS_ELEM[channel]);
            cb_arrow.setSelectedItem(this.ARROW[channel]);
            tf_buki_sp_rate.setText(Double.toString(this.SP_R[channel]));
            tf_mag_rate.setText(Double.toString(this.MAG_R[channel]));
            tf_mag_delay.setText(Double.toString(this.MAG_D[channel]));
            tf_mag_power.setText(Double.toString(this.MAG_P[channel]));
            tb_ts_sp.setSelected(TS_SP[channel]);

            if (calc.buki.element_enchant) {
                cb_elem_1.setEnabled(true);
            } else {
                cb_elem_1.setSelectedIndex(0);
                cb_elem_1.setEnabled(false);
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("copy")) {
                copy = cb_eq_ch.getSelectedIndex();
            }
            if (e.getActionCommand().equals("paste")) {
                mem.load_from_mem(copy);
            }
            if (e.getActionCommand().equals("reset")) {

                for (int i = 0; i < eq_list.length; i++) {
                    cb_eq[i].setSelectedIndex(0);
                    cb_eq_en[i].setSelectedIndex(0);
                }

                cb_elem_1.setSelectedIndex(0);
                cb_ts_elem.setSelectedIndex(0);

                tb_blessed1.setSelected(false);
                cb_arrow.setSelectedIndex(-1);
            }
            if (e.getActionCommand().equals("ch")) {
                mem.copy_to_mem(curr);
                mem.load_from_mem(cb_eq_ch.getSelectedIndex());
                curr = cb_eq_ch.getSelectedIndex();
                calc.update();
            }
        }
    }
    Memory mem = new Memory();
    int copy = 0;
    int curr = 0;

    private void init_mem() {
        loadEquip();
        mem.clear();
        mem.load_from_mem(cb_eq_ch.getSelectedIndex());
        calc.update();
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource().equals(tabpane)) {
            int tab_id = tabpane.getSelectedIndex();

            if (tab_id == 0 || tab_id == 1) {
                JPanel p = panels[tab_id];
                commons.stream().forEach((c) -> {
                    p.add(c);
                });
            }

            calc.update();
        }

        if (e.getSource().equals(s_target_mr)) {
            lab_target_mr.setText(Integer.toString(s_target_mr.getValue()));
        }
        for (int i = 0; i < elem_list.length; i++) {
            if (e.getSource().equals(s_target_res[i])) {
                lab_target_resist[i].setText(Integer.toString(s_target_res[i].getValue()));
            }
        }
    }

    private Document createDocument() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element root = document.createElement("root");
        document.appendChild(root);

        Element e_class = document.createElement("クラス");
        root.appendChild(e_class);
        e_class.setTextContent(cb_cls.getSelectedItem().toString());

        Element e_lev = document.createElement("レベル");
        root.appendChild(e_lev);
        e_lev.setTextContent(cb_lev.getSelectedItem().toString());

        Element e_status = document.createElement("ステータス");
        root.appendChild(e_status);

        String st[] = {"---", "STR", "DEX", "CON", "INT", "WIS", "CHA"};

        Element e_base = document.createElement("base");
        e_status.appendChild(e_base);
        for (int i = 0; i < 6; i++) {
            Element e_base_data = document.createElement("data");
            e_base_data.setAttribute("val", st[i + 1]);
            e_base_data.setAttribute("num", Integer.toString(calc.getST_REM(i)));
            e_base.appendChild(e_base_data);
        }

        Element e_level = document.createElement("level");
        e_status.appendChild(e_level);
        for (int i = 0; i < lev.size; i++) {
            Element e_rem_level_data = document.createElement("data");
            e_rem_level_data.setAttribute("lev", Integer.toString(i + 51));
            e_rem_level_data.setAttribute("val", st[lev.field[i] + 1]);
            e_level.appendChild(e_rem_level_data);
        }

        Element e_elixir = document.createElement("elixir");
        e_status.appendChild(e_elixir);
        for (int i = 0; i < cb_elixir.length; i++) {
            Element e_elixir_data = document.createElement("data");
            e_elixir_data.setAttribute("lev", cb_elixir_level[i].getSelectedItem().toString());
            e_elixir_data.setAttribute("val", cb_elixir[i].getSelectedItem().toString());
            e_elixir.appendChild(e_elixir_data);
        }

        Element e_polymorph = document.createElement("変身");
        root.appendChild(e_polymorph);
        e_polymorph.setTextContent(cb_morph_type.getSelectedItem().toString());

        Element e_polymorph_level = document.createElement("変身レベル");
        root.appendChild(e_polymorph_level);
        e_polymorph_level.setTextContent(cb_morph_level.getSelectedItem().toString());

        Element e_morph_manually = document.createElement("変身設定");
        e_morph_manually.setTextContent(Boolean.toString(cb_speed_auto.isSelected()));
        root.appendChild(e_morph_manually);

        Element e_buki_manually = document.createElement("武器設定");
        e_buki_manually.setTextContent(Boolean.toString(cb_mag_auto.isSelected()));
        root.appendChild(e_buki_manually);

        if (!cb_speed_auto.isSelected()) {
            e_morph_manually.setAttribute("速度", tf_speed.getText());
            e_morph_manually.setAttribute("加速", tf_acc.getText());
            e_morph_manually.setAttribute("攻魔", tf_magic_speed_main.getText());
            e_morph_manually.setAttribute("補魔", tf_magic_speed_sub.getText());
        }

        Element e_enchant = document.createElement("エンチャント");
        root.appendChild(e_enchant);
        for (int i = 0; i < cb_buff.length; i++) {
            if (cb_buff[i] != null) {
                Element e_enchant_data = document.createElement("data");
                e_enchant_data.setAttribute("id", Integer.toString(i));
                e_enchant_data.setAttribute("val", Boolean.toString(cb_buff[i].isSelected()));
                if (cb_buff_group[i] != null) {
                    e_enchant_data.setAttribute("select", Integer.toString(cb_buff_group[i].getSelectedIndex()));
                }
                e_enchant.appendChild(e_enchant_data);
            }
        }

        Element pattern = document.createElement("文様");
        root.appendChild(pattern);
        Element e_pattern_l = document.createElement("左手");
        pattern.appendChild(e_pattern_l);
        e_pattern_l.setTextContent(cb_pattern_l.getSelectedItem().toString());
        Element e_pattern_r = document.createElement("右手");
        pattern.appendChild(e_pattern_r);
        e_pattern_r.setTextContent(cb_pattern_r.getSelectedItem().toString());
        Element e_pattern_c = document.createElement("背中");
        pattern.appendChild(e_pattern_c);
        e_pattern_c.setTextContent(cb_pattern_c.getSelectedItem().toString());
        Element e_pattern_l2 = document.createElement("左腕");
        pattern.appendChild(e_pattern_l2);
        e_pattern_l2.setTextContent(cb_pattern_l2.getSelectedItem().toString());
        Element e_pattern_r2 = document.createElement("右腕");
        pattern.appendChild(e_pattern_r2);
        e_pattern_r2.setTextContent(cb_pattern_r2.getSelectedItem().toString());

        for (int i = 0; i < cb_eq_ch.getItemCount(); i++) {
            Element e_equip = document.createElement("装備");
            e_equip.setAttribute("id", Integer.toString(i));
            root.appendChild(e_equip);
            for (int j = 0; j < eq_list.length; j++) {
                Element e_equip_data = document.createElement(eq_list[j]);
                e_equip_data.setAttribute("id", Integer.toString(j));
                e_equip_data.setAttribute("enchant", Integer.toString(mem.EN[j][i]));
                if (eq_list[j].equals("武器")) {
                    if (j == 0) {
                        e_equip_data.setAttribute("element", Integer.toString(mem.ELEM1[i]));
                        e_equip_data.setAttribute("blessed", Boolean.toString(mem.BL1[i]));
                        e_equip_data.setAttribute("sp_rate", Double.toString(mem.SP_R[i]));
                        e_equip_data.setAttribute("mag_rate", Double.toString(mem.MAG_R[i]));
                        e_equip_data.setAttribute("mag_power", Double.toString(mem.MAG_P[i]));
                        e_equip_data.setAttribute("mag_delay", Double.toString(mem.MAG_D[i]));
                    }
                    if (j == 1) {
                        e_equip_data.setAttribute("element", Integer.toString(mem.ELEM2[i]));
                        e_equip_data.setAttribute("blessed", Boolean.toString(mem.BL2[i]));
                    }

                }
                if (eq_list[j].equals("シャツ")) {
                    e_equip_data.setAttribute("element", Integer.toString(mem.TS_ELEM[i]));
                    e_equip_data.setAttribute("tokusei", Boolean.toString(mem.TS_SP[i]));
                }
                e_equip_data.setTextContent(mem.EQ[j][i] != null ? mem.EQ[j][i] : "");
                e_equip.appendChild(e_equip_data);
            }
            Element e_arrow = document.createElement("アロー");
            e_arrow.setTextContent(mem.ARROW[i]);
            e_equip.appendChild(e_arrow);
        }

        Element e_magic = document.createElement("魔法使用");
        e_magic.setTextContent(cb_magic.getSelectedItem().toString());
        root.appendChild(e_magic);

        Element e_weight = document.createElement("重量");
        e_weight.setTextContent(cb_weight.getSelectedItem().toString());
        root.appendChild(e_weight);

        return document;
    }

    private void loadDocument(Document document) {
        cb_cls.setSelectedItem(document.getDocumentElement().getElementsByTagName("クラス").item(0).getTextContent());
        cb_lev.setSelectedItem(document.getDocumentElement().getElementsByTagName("レベル").item(0).getTextContent());

        Node n_base = document.getDocumentElement().getElementsByTagName("base").item(0);
        for (int i = 0; i < n_base.getChildNodes().getLength(); i++) {
            Node item = n_base.getChildNodes().item(i);
            if (item.hasAttributes()) {
                for (int j = 0; j < Integer.parseInt(item.getAttributes().getNamedItem("num").getNodeValue()); j++) {
                    switch (item.getAttributes().getNamedItem("val").getNodeValue()) {
                        case "STR":
                            calc.addRem(STR);
                            break;
                        case "DEX":
                            calc.addRem(DEX);
                            break;
                        case "CON":
                            calc.addRem(CON);
                            break;
                        case "WIS":
                            calc.addRem(WIS);
                            break;
                        case "INT":
                            calc.addRem(INT);
                            break;
                        case "CHA":
                            calc.addRem(CHA);
                            break;
                    }
                }
            }
        }

        Node n_level = document.getDocumentElement().getElementsByTagName("level").item(0);
        for (int i = 0; i < n_level.getChildNodes().getLength(); i++) {
            Node item = n_level.getChildNodes().item(i);
            if (item.hasAttributes()) {
                String st[] = {"---", "STR", "DEX", "CON", "INT", "WIS", "CHA"};
                for (int j = 0; j < 7; j++) {
                    if (item.getAttributes().getNamedItem("val").getNodeValue().equals(st[j])) {
                        lev.field[Integer.parseInt(item.getAttributes().getNamedItem("lev").getNodeValue()) - 51] = j - 1;
                    }
                }
            }
        }
        calc.update();
        lev.repaint();

        Node n_elixir = document.getDocumentElement().getElementsByTagName("elixir").item(0);
        for (int i = 0, index = 0; i < n_elixir.getChildNodes().getLength() && index < cb_elixir.length; i++) {
            Node item = n_elixir.getChildNodes().item(i);
            if (item.hasAttributes()) {
                cb_elixir[index].setSelectedItem(item.getAttributes().getNamedItem("val").getNodeValue());
                cb_elixir_level[index].setSelectedItem(item.getAttributes().getNamedItem("lev").getNodeValue());
                index++;
            }
        }

        cb_morph_type.setSelectedItem(document.getDocumentElement().getElementsByTagName("変身").item(0).getTextContent());
        cb_morph_level.setSelectedItem(document.getDocumentElement().getElementsByTagName("変身レベル").item(0).getTextContent());

        Node n_morph_manually = document.getDocumentElement().getElementsByTagName("変身設定").item(0);
        cb_speed_auto.setSelected(Boolean.parseBoolean(n_morph_manually.getTextContent()));

        Node n_buki_manually = document.getDocumentElement().getElementsByTagName("武器設定").item(0);
        cb_mag_auto.setSelected(Boolean.parseBoolean(n_buki_manually.getTextContent()));

        if (!cb_speed_auto.isSelected()) {
            tf_speed.setText(n_morph_manually.getAttributes().getNamedItem("速度").getNodeValue());
            tf_acc.setText(n_morph_manually.getAttributes().getNamedItem("加速").getNodeValue());
            tf_magic_speed_main.setText(n_morph_manually.getAttributes().getNamedItem("攻魔").getNodeValue());
            tf_magic_speed_sub.setText(n_morph_manually.getAttributes().getNamedItem("補魔").getNodeValue());
        }

        Node n_enchant = document.getDocumentElement().getElementsByTagName("エンチャント").item(0);
        for (int i = 0; i < n_enchant.getChildNodes().getLength(); i++) {
            Node item = n_enchant.getChildNodes().item(i);
            if (item.hasAttributes()) {
                int id = Integer.parseInt(item.getAttributes().getNamedItem("id").getNodeValue());
                cb_buff[id].setSelected(Boolean.parseBoolean(item.getAttributes().getNamedItem("val").getNodeValue()));
                if (cb_buff_group[id] != null) {
                    cb_buff_group[id].setSelectedIndex(Integer.parseInt(item.getAttributes().getNamedItem("select").getNodeValue()));
                }
            }
        }

        Node pattern = document.getDocumentElement().getElementsByTagName("文様").item(0);

        for (int i = 0; i < pattern.getChildNodes().getLength(); i++) {
            switch (pattern.getChildNodes().item(i).getNodeName()) {
                case "左手":
                    cb_pattern_l.setSelectedItem(pattern.getChildNodes().item(i).getTextContent());
                    break;
                case "右手":
                    cb_pattern_r.setSelectedItem(pattern.getChildNodes().item(i).getTextContent());
                    break;
                case "背中":
                    cb_pattern_c.setSelectedItem(pattern.getChildNodes().item(i).getTextContent());
                    break;
                case "左腕":
                    cb_pattern_l2.setSelectedItem(pattern.getChildNodes().item(i).getTextContent());
                    break;
                case "右腕":
                    cb_pattern_r2.setSelectedItem(pattern.getChildNodes().item(i).getTextContent());
                    break;
            }
        }

        for (int i = 0; i < cb_eq_ch.getItemCount(); i++) {
            Node n_equip = document.getDocumentElement().getElementsByTagName("装備").item(i);
            int cn = Integer.parseInt(n_equip.getAttributes().getNamedItem("id").getNodeValue());

            for (int j = 0; j < n_equip.getChildNodes().getLength(); j++) {
                Node item = n_equip.getChildNodes().item(j);
                if (item.hasAttributes()) {
                    int id = Integer.parseInt(item.getAttributes().getNamedItem("id").getNodeValue());
                    mem.EQ[id][cn] = item.getTextContent();
                    mem.EN[id][cn] = Integer.parseInt(item.getAttributes().getNamedItem("enchant").getNodeValue());
                    if (eq_list[id].equals("武器")) {
                        if (id == 0) {
                            mem.ELEM1[cn] = Integer.parseInt(item.getAttributes().getNamedItem("element").getNodeValue());
                            mem.BL1[cn] = Boolean.parseBoolean(item.getAttributes().getNamedItem("blessed").getNodeValue());
                            mem.SP_R[cn] = Double.parseDouble(item.getAttributes().getNamedItem("sp_rate").getNodeValue());
                            mem.MAG_R[cn] = Double.parseDouble(item.getAttributes().getNamedItem("mag_rate").getNodeValue());
                            mem.MAG_P[cn] = Double.parseDouble(item.getAttributes().getNamedItem("mag_power").getNodeValue());
                            mem.MAG_D[cn] = Double.parseDouble(item.getAttributes().getNamedItem("mag_delay").getNodeValue());
                        }
                        if (id == 1) {
                            mem.ELEM2[cn] = Integer.parseInt(item.getAttributes().getNamedItem("element").getNodeValue());
                            mem.BL2[cn] = Boolean.parseBoolean(item.getAttributes().getNamedItem("blessed").getNodeValue());
                        }
                    }
                    if (eq_list[id].equals("シャツ")) {
                        mem.TS_ELEM[cn] = Integer.parseInt(item.getAttributes().getNamedItem("element").getNodeValue());
                        if (item.getAttributes().getNamedItem("tokusei") != null) {
                            mem.TS_SP[cn] = Boolean.parseBoolean(item.getAttributes().getNamedItem("tokusei").getNodeValue());
                        }
                    }
                }
                if (item.getNodeName().equals("アロー")) {
                    mem.ARROW[cn] = item.getTextContent();
                }
            }
        }

        if (document.getDocumentElement().getElementsByTagName("魔法使用").getLength() == 1) {
            Node magic = document.getDocumentElement().getElementsByTagName("魔法使用").item(0);
            cb_magic.setSelectedItem(magic.getTextContent());
        }

        if (document.getDocumentElement().getElementsByTagName("重量").getLength() == 1) {
            cb_weight.setSelectedItem(document.getDocumentElement().getElementsByTagName("重量").item(0).getTextContent());
        }

        mem.load_from_mem(cb_eq_ch.getSelectedIndex());

        calc.update();
    }

}
