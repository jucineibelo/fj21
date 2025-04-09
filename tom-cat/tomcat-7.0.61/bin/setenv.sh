JAVA_OPTS="$JAVA_OPTS -Xms256m -Xmx2048m -XX:+UseConcMarkSweepGC -Djava.awt.headless=true"
JAVA_OPTS="$JAVA_OPTS -Dfile.encoding=UTF-8 -Dsun.jnu.encoding=UTF-8 -Dmail.mime.ignoreunknownencoding=true"
CATALINA_PID=$CATALINA_HOME/catalina.pid
export LD_LIBRARY_PATH=$LD_LIBRARY_PATH:$CATALINA_HOME/lib/sigar
