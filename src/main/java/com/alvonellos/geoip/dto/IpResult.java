package com.alvonellos.geoip.dto;

import com.maxmind.geoip2.model.CityResponse;
import lombok.Builder;

@Builder
public record IpResult(String country, String subdivision, String city, String postal, String latitude,
                       String longitude) {

    public static IpResult getIpResult(CityResponse response) {
        return IpResult.builder()
              .country(response.getCountry().getName())
              .subdivision(response.getMostSpecificSubdivision().getName())
              .city(response.getCity().getName())
              .postal(response.getPostal().getCode())
              .latitude(String.format("%03.6f", response.getLocation().getLatitude()))
              .longitude(String.format("%03.6f", response.getLocation().getLongitude()))
              .build();
    }
}
