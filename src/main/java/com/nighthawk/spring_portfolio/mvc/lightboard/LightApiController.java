package com.nighthawk.spring_portfolio.mvc.lightboard;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/light")
public class LightApiController {

    // Get random lightboard
    @GetMapping("/")
    public ResponseEntity<PixelBoysFighting> createArray() {
        return new ResponseEntity<>( new PixelBoysFighting(5, 5), HttpStatus.OK);
    }

    // Iterate over lightboard
    @GetMapping("/{pixelBoy}")
    public ResponseEntity<PixelBoysFighting> iterate(@PathVariable PixelBoysFighting pixelBoy) {
        pixelBoy.iterate(1);
        return new ResponseEntity<PixelBoysFighting>(pixelBoy, HttpStatus.OK);       
    }

}
