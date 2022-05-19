package com.oop.projekt;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//// Delete nupp on veel tegemata
public class Peaklass extends Application {

    public static void main(String[] args) {
        Peaklass.launch(args);
    }

    @Override
    public void start(Stage peaLava) throws FileNotFoundException {
        List<Osaleja> osalejateList = new ArrayList<>();
        /*
        try (Scanner sc = new Scanner(new File("projekt\\src\\main\\java\\com\\oop\\projekt\\osalejad.txt"), "UTF-8")) { //loeme osalejad osalejate failist
            while (sc.hasNextLine()) {
                String rida = sc.nextLine();
                Osaleja uus = new Osaleja(rida);
                osalejateList.add(uus);
            }
        }catch (FileNotFoundException e){
            System.out.println("kys");
        }
         */
        //TODO me peame midagi failist lugema
        //Sissejuhatav tekst
        /*System.out.println("Programm aitab teil hallata töötube ja/või kontoriruume.");
        System.out.println("Võite trükkida inimesed ja ruumid eelnevalt failidesse osalejad.txt ja tootoad.txt või sisestada infot jooksvalt konsooli.");
        System.out.println("Programmi töö lõppedes trükitakse ruumides töötavate inimeste plaan ekraanile ja ka faili loplikplaan.txt");
        System.out.println("Iga isik on võimeline osalema ainult ühes töötoas korraga.");
        System.out.println("Osalejate nimed EI TOHI korduda.");
        System.out.print("Hetkel olemasolevad osalejad: ");     //prindime osalejate nimed
        for (Osaleja a : osalejateList) {
            System.out.print(a.toString());
        }
        System.out.println();*/


        Text tekstJuhend = new Text(50, 100, "Kirjutage vastav nimi lahtrisse, ning lisage töötuba või osaleja.");

        tekstJuhend.setFont(Font.font("null",
                FontWeight.NORMAL, 12));




        Button nuppLisaTootuba = new Button("Lisa Töötuba");

        //TODO nupp mis kirjutab kõik kuhugi faili

        TextField input = new TextField();

        input.setMinWidth(300);
        input.setMinHeight(30);



        VBox vbox = new VBox();
        vbox.getChildren().addAll(input);
        HBox hbox = new HBox();
        hbox.getChildren().addAll(nuppLisaTootuba);

        TreeItem<VihkameTreeview> rootNode = new TreeItem<>();
        rootNode.setExpanded(true);
        TreeView<VihkameTreeview> treeView = new TreeView<>(rootNode);
        treeView.setShowRoot(false);
        vbox.getChildren().add(treeView);
        treeView.setEditable(true);
        nuppLisaTootuba.setOnAction(e -> {
            String töötoaNimi = input.getText();
            Töötuba uusTöötuba = new Töötuba(töötoaNimi);
            input.setText("");
            TreeItem<VihkameTreeview> uusNode = new TreeItem<>(uusTöötuba);

            Button editTöötuba = new Button("Edit");
            Button deleteTöötuba = new Button("Delete");
            Button LisaOsaleja = new Button("Lisa Osaleja");
            HBox miniHbox = new HBox(deleteTöötuba,editTöötuba,LisaOsaleja);

            editTöötuba.setOnAction(g -> {
                String kasutajaSisend = input.getText();
                uusTöötuba.setName(kasutajaSisend);
                input.setText("");
                uusNode.setValue(uusTöötuba);
                treeView.edit(uusNode);
                treeView.refresh();
            });

            deleteTöötuba.setOnAction(s -> {
                uusNode.getParent().getChildren().remove(uusNode);
            });

            LisaOsaleja.setOnAction(f -> {
                String osalejaNimi = input.getText();
                Osaleja uusOsaleja = new Osaleja(osalejaNimi);
                uusTöötuba.lisaOsaleja(uusOsaleja);
                input.setText("");
                TreeItem<VihkameTreeview> uusOsalejaNode = new TreeItem<>(uusOsaleja);
                uusNode.getChildren().add(uusOsalejaNode);


                Button editOsaleja = new Button("Edit");
                Button deleteOsaleja = new Button("Delete");

                HBox miniMiniHbox = new HBox(deleteOsaleja,editOsaleja);
                uusOsalejaNode.setGraphic(miniMiniHbox);
                editOsaleja.setOnAction(h -> {
                    String kasutajaSisend = input.getText();
                    uusOsaleja.setName(kasutajaSisend);
                    input.setText("");
                    uusOsalejaNode.setValue(uusOsaleja);
                    treeView.edit(uusOsalejaNode);
                    treeView.refresh();
                });

                deleteOsaleja.setOnAction(t -> {
                    uusOsalejaNode.getParent().getChildren().remove(uusOsalejaNode);
                });

            });
            uusNode.setGraphic(miniHbox);
            rootNode.getChildren().add(uusNode);
        });





        ScrollPane scroller = new ScrollPane(vbox);
        scroller.setFitToWidth(true);
        scroller.setFitToHeight(true);
        BorderPane juurpaigutus = new BorderPane();
        juurpaigutus.setCenter(scroller);
        juurpaigutus.setTop(tekstJuhend);
        juurpaigutus.setBottom(hbox);
        Scene scene = new Scene(juurpaigutus);
        peaLava.setScene(scene);
        peaLava.setResizable(true);
        peaLava.setTitle("Töötubade haldaja");
        peaLava.show();
        /*
        for (Osaleja osaleja : osalejateList) {
            System.out.println(osaleja);
        }
         */
    }
}

/*


                try (PrintWriter out = new PrintWriter("src/töötubade_plaan.txt", "UTF-8")){    //trükime töötubade seisu faili talletamiseks
                    for (Töötuba tuba: tootubadeList) {
                        out.println(tuba.toString());
                    }
                    out.close();
                }






            }
 */
