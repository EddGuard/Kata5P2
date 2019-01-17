/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata4.view;

import java.util.List;
import java.util.function.Predicate;
import kata4.model.Histogram;
import kata4.model.Mail;

/**
 *
 * @author Eduardo
 */
public class MailHistogramBuilder {
    private Histogram<String> histogram;

    public Histogram<String> build(List<Mail> listaCorreos){
        histogram = new Histogram<>();
        listaCorreos.stream().filter(new PredicateImpl()).forEach((correo) -> {
            histogram.increment(correo.getDomain());
        });
        return histogram;
    }

    private static class PredicateImpl implements Predicate<Mail> {

        public PredicateImpl() {
        }

        @Override
        public boolean test(Mail correo) {
            return correo != null;
        }
    }
}