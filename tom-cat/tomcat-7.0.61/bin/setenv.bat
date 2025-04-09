set JAVA_OPTS=%JAVA_OPTS% -Xms256m -Xmx2048m -XX:+UseConcMarkSweepGC -Djava.awt.headless=true
set JAVA_OPTS=%JAVA_OPTS% -Dfile.encoding=UTF-8 -Dsun.jnu.encoding=UTF-8 -Dmail.mime.ignoreunknownencoding=true
set PATH=%PATH%;%CATALINA_HOME%\lib\sigar
