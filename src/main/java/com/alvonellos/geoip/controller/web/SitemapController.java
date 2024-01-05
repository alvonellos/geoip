package com.alvonellos.geoip.controller.web;

import com.alvonellos.geoip.dto.notxml.XmlUrl;
import com.alvonellos.geoip.dto.notxml.XmlUrlSet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SitemapController {

    @GetMapping(value = "/sitemap.xml", produces = "application/xml")
    @ResponseBody
    public XmlUrlSet main() {
        XmlUrlSet xmlUrlSet = new XmlUrlSet();
        create(xmlUrlSet, "/", XmlUrl.Priority.HIGH);

        return xmlUrlSet;
    }

    private void create(XmlUrlSet xmlUrlSet, String link, XmlUrl.Priority priority) {
        xmlUrlSet.addUrl(new XmlUrl("https://jizzed.xyz" + link, priority));
    }

}