FROM tomcat:9.0

RUN rm -rf /usr/local/tomcat/webapps/ROOT


COPY ./target /usr/local/tomcat/webapps/ROOT


EXPOSE 8080
CMD ["catalina.sh", "run"]
#CMD ["/usr/local/tomcat/bin/startup.sh"]