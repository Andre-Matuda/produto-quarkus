# ==========================================
# ESTÁGIO 1: Compilação da aplicação (Build)
# ==========================================
FROM maven:3.9.6-eclipse-temurin-21 AS build
# Define o diretório de trabalho dentro do container de build
WORKDIR /build

# Copia o arquivo de configuração do Maven (pom.xml)
COPY pom.xml .

# Copia a pasta com o código fonte do Java completo
COPY . .

# CORRIGIDO: Usamos "mvn" direto em vez de "./mvnw"
# Isso elimina a necessidade do comando "chmod +x mvnw"
RUN mvn package -Dquarkus.package.type=fast-jar -DskipTests
# ==========================================
# ESTÁGIO 2: Imagem final de execução (Runtime)
# ==========================================
FROM registry.access.redhat.com/ubi9/openjdk-21-runtime:1.24

ENV LANGUAGE='en_US:en'

# Copia os arquivos compilados do Estágio 1 (build) direto para a pasta de deploy
COPY --from=build --chown=185 /build/target/quarkus-app/lib/ /deployments/lib/
COPY --from=build --chown=185 /build/target/quarkus-app/*.jar /deployments/
COPY --from=build --chown=185 /build/target/quarkus-app/app/ /deployments/app/
COPY --from=build --chown=185 /build/target/quarkus-app/quarkus/ /deployments/quarkus/

EXPOSE 8080
USER 185

ENV JAVA_OPTS_APPEND="-Dquarkus.http.host=0.0.0.0 -Djava.util.logging.manager=org.jboss.logmanager.LogManager"
ENV JAVA_APP_JAR="/deployments/quarkus-run.jar"

ENTRYPOINT [ "/opt/jboss/container/java/run/run-java.sh" ]
