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

    public static void main(String[] args) throws IOException {
        MailListReader lecturaLista = new MailListReader();
        String fileName = "email.txt";
        List<Mail> mailList = lecturaLista.read(fileName);
        MailHistogramBuilder histogramBuild = new MailHistogramBuilder();
        Histogram<String> histogram = histogramBuild.build(mailList);
        /*Histogram<String> histogram;
        histogram = histogramBuild.build(mailList);
        */new HistogramDisplay(histogram).execute();

    }
}