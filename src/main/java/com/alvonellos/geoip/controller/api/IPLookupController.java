package com.alvonellos.geoip.controller.api;

import com.alvonellos.geoip.annotations.ApiPrefixController;
import com.alvonellos.geoip.dto.IpResult;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.InetAddress;

@RestController
@ApiPrefixController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class    IPLookupController {
    private final DatabaseReader databaseReader;

    //get mapping for the database
    @GetMapping("iplookup/{ip}")
    public ResponseEntity<IpResult> get(@PathVariable("ip") String ip) throws IOException, GeoIp2Exception {
        return ResponseEntity.ok(IpResult.getIpResult(
                databaseReader.city(InetAddress.getByName(ip))
        ));
    }

    @PostMapping("iplookup")
    public ResponseEntity<IpResult> post(@RequestParam String ip) throws IOException, GeoIp2Exception {
        return this.get(ip);
    }
}
