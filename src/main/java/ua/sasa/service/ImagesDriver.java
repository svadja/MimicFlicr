package ua.sasa.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ua.sasa.dao.CommonDao;
import ua.sasa.dao.ImagesDao;
import ua.sasa.domain.Image;

@Service
public class ImagesDriver {

    @Value("${store.dir}")
    private String storeDir;

    @Autowired
    CommonDao dao;

    @Autowired
    ImagesDao imagesDao;

    public boolean saveImage(Image image, MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                String fileName = image.hashCode() + "." + file.getOriginalFilename().split("\\.")[1];
                String path = storeDir + fileName;
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(path));
                stream.write(bytes);
                stream.close();
                image.setFilePath(fileName);
                image.setDateCreation(Instant.now());
                dao.saveOrUpdate(image);
                return true;
            } catch (Exception e) {
                System.out.println(e.getMessage()); 
                return false;
            }
        } else {
            return false;
        }

    }

    public List<Image> getImage(String name, String description, Instant dateStart, Instant dateEnd) {
        return imagesDao.getImages(name, description, dateStart, dateEnd);
    }

    public Image getImageById(long id) {
        return (Image) dao.getById(Image.class.getName(), id);
    }

    public void deleteById(long id) {
        Image image = (Image) dao.getById(Image.class.getName(), id);
        File file = new File(storeDir + image.getFilePath());
        if (file.exists()){
            file.delete();
        }
        dao.deleteById(Image.class.getName(), id);
    }
}
