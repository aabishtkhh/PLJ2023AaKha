FROM node:18.15.0-alpine AS builder
WORKDIR /movie-reviews
COPY package.json .
COPY yarn.lock .
RUN yarn install 
COPY . .
RUN yarn build

FROM nginx:1.19.0
WORKDIR /usr/share/nginx/html
RUN rm -rf ./*
COPY --from=builder /movie-reviews/dist .
ENTRYPOINT ["nginx", "-g", "daemon off;"]