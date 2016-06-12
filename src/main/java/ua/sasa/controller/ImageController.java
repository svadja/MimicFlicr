package ua.sasa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ua.sasa.domain.Image;
import ua.sasa.service.ImagesDriver;

/**
 *
 * @author sasav
 */
@RestController
public class ImageController {

    @Autowired
    ImagesDriver imageDriver;

    @RequestMapping(value = "/images", method = RequestMethod.POST)
    public ResponseEntity createImage(@ModelAttribute("image") Image image, @RequestParam("file") MultipartFile file) {
        if (imageDriver.saveImage(image, file)) {
            return ResponseEntity.ok("Success");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error save image");
        }
    }

    @RequestMapping(value = "/images", method = RequestMethod.GET)
    public ResponseEntity getImages(@RequestParam(required = false) String name, @RequestParam(required = false) String description, @RequestParam(required = false) Long dateStart,  @RequestParam(required = false) Long dateEnd) {
        List<Image> images = imageDriver.getImage(name, description, dateStart, dateEnd);
        return ResponseEntity.ok(images);
    }

    @RequestMapping(value = "/images/{id}", method = RequestMethod.GET)
    public ResponseEntity getImage(@PathVariable long id) {
        return ResponseEntity.ok(imageDriver.getImageById(id));
    }

    @RequestMapping(value = "/images/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateImage() {
        return ResponseEntity.ok("Ok");
    }

    @RequestMapping(value = "/images/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteImage(@PathVariable long id) {
        imageDriver.deleteById(id);
        return ResponseEntity.ok("Try to remove");
    }

}
