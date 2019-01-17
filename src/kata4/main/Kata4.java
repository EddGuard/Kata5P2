/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata4.main;

import java.io.IOException;
import java.util.List;
import kata4.model.Histogram;
import kata4.model.Mail;
import kata4.view.HistogramDisplay;
import kata4.view.MailHistogramBuilder;
import kata4.view.MailListReader;

/**
 *
 * @author Eduardo
 */
public class Kata4 {
    
    //private static HistogramDisplay histoDisplay;
    private static MailListReader lecturaLista;
    private static String fileName;
    private static List<Mail> mailList;
    private static MailHistogramBuilder histogramBuild;
    private static Histogram<String> histogram;
    
    public static void main(String[] args) throws IOException {
        execute();
    }
    
    private static void execute(){
        input();
        process();
        output();
    }

    private static void input(){
        lecturaLista = new MailListReader();
        fileName = "email.txt";
        mailList = lecturaLista.read(fileName);
    }

    private static void process(){
        histogramBuild = new MailHistogramBuilder();
        histogram = histogramBuild.build(mailList);
    }

    private static void output(){
        new HistogramDisplay(histogram).execute();
    }
}