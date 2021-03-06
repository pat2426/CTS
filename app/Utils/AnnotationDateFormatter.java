package Utils;

import play.data.format.Formatters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Meaks on 12/6/2015.
 */public class AnnotationDateFormatter extends Formatters.AnnotationFormatter<DateFormat, Date> {

    @Override
    public Date parse(DateFormat annotation, String text, Locale locale)
            throws ParseException {
        if(text == null || text.trim().isEmpty()) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(annotation.value(),
                locale);
        sdf.setLenient(true);
        return sdf.parse(text);
    }

    @Override
    public String print(DateFormat annotation, Date date, Locale locale) {
        if(date==null) {
            return "";
        }

        return new SimpleDateFormat(annotation.value(), locale)
                .format(date);
    }
}
