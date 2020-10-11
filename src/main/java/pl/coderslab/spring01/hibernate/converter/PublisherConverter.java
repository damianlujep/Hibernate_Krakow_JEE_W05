package pl.coderslab.spring01.hibernate.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.spring01.hibernate.controller.entity.Publisher;
import pl.coderslab.spring01.hibernate.dao.PublisherDao;

public class PublisherConverter implements Converter<String, Publisher> {
    @Autowired
    private PublisherDao pd;

    @Override
    public Publisher convert(String publisherID) {
        return pd.findById(Long.parseLong(publisherID));
    }
}
