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
import kata4.view.MailListReaderBD;

/**
 *
 * @author Eduardo
 */
public class Kata4 {
    
    public static void main(String[] args) throws IOException {
        MailListReaderBD lecturaLista = new MailListReaderBD();
        List<Mail> mailList = lecturaLista.read();
        MailHistogramBuilder histogramBuild = new MailHistogramBuilder();
        lecturaLista.list();
    }    
}