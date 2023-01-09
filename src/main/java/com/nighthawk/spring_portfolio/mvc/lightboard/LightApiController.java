package com.nighthawk.spring_portfolio.mvc.lightboard;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/light")
public class LightApiController {

    // Get random lightboard
    @GetMapping("/")
    public ResponseEntity<String> createArray() {
        PixelBoys
        return new ResponseEntity<>( new PixelBoysFighting(5, 5).toString(), HttpStatus.OK);
    }

    // Iterate over lightboard
    @GetMapping("/{pixelBoy}")
    public ResponseEntity<PixelBoysFighting> iterate(@PathVariable PixelBoysFighting pixelBoy) {
        pixelBoy.iterate(1);
        return new ResponseEntity<PixelBoysFighting>(pixelBoy, HttpStatus.OK);       
    }

}
