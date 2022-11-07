# build stage
FROM node:lts-alpine as build-stage
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY ./ .
RUN npm run build

# production stage
FROM nginx:stable-alpine as production-stage
COPY --from=build-stage /app/dist /usr/share/nginx/html
COPY nginx.conf /etc/nginx/conf.d/default.conf
COPY entrypoint.sh /
RUN chmod +x /entrypoint.sh
EXPOSE 8080 443
ENTRYPOINT [ "/entrypoint.sh" ]
#CMD ["nginx", "-g", "daemon off;"]